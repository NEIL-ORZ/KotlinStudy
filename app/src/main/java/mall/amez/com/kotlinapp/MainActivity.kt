package mall.amez.com.kotlinapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //回调网络请求
        RetrofitHelper.getApi().getUser("bennyhuo").enqueue(object : Callback<User> {
            override fun onFailure(call: Call<User>, t: Throwable) {
                Log.e("zh", "onFailure = " + t.printStackTrace().toString())
            }

            override fun onResponse(call: Call<User>, response: Response<User>) {
                Log.e("zh", "onResponse = " + response.body().toString())
            }
        })

        //协程网络请求
        MainScope().launch {
            try {
                RetrofitHelper.getApi().getUser1("bennyhuo").await()
            } catch (e: Exception) {
                Log.e("zh", "await = " + e.printStackTrace().toString())
            }
        }

        //协程suspend 函数网络请求
        MainScope().launch {
            try {
                RetrofitHelper.getApi().getUser2("bennyhuo")
            } catch (e: Exception) {
                Log.e("zh", "suspend = " + e.printStackTrace().toString())
            }
        }
    }


}
