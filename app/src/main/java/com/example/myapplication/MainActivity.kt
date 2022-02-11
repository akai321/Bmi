package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import com.example.myapplication.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    //使用View-binding取得元件
    /*
    現在build.gradle(資料夾控制程式)的android{...}裡面加入下面程式碼:
        buildFeatures{
            viewBinding true
        }
       加入後，layout(畫面配置檔)內每個.xml都會自動產生一個binding類別，
       例如:activity_main.xml -> 會自動產生一個名稱為ActivityMainBinding類別，
       如果是activity_result.xml 則產生ActivityResultBinnding，名稱使用駝峰式命名法。

     */
    //宣告binding物件為此類別的屬性，以便未來可以在其他的方法中使用binding物件
    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //取得binding物件，呼叫binding類別的inflate方法( 呼叫getLayoutInflater方法取得物件並傳入)
        binding = ActivityMainBinding.inflate(layoutInflater)
        // setContentView(R.layout.activity_main) //原本的方法

        //取得layout內.xml檔內的各個原件 轉成Java物件的方法
            //一、使用View-binding方法取得元件
                    setContentView(binding.root)  //binding.root(建構ActivityMainBinding的原始根檔案) 等於 R.layout.activity_main 的意思
                    binding.edWeight


            //二、使用kotlin語言的外掛類別庫的合成的方式取得元件
            /*
            需在build.gradle(Module:app)內上方的「plugins」插件區塊中加入下面程式碼:
            id 'kotlin-android-extensions'

            備註:Kotlin的新版本從1.4.20開始，不再自動導入kotlin-android-extensions這個用合成synthetics方式取得元件的類別庫，也不會在以後的版本中包入這個功能，
            原因是他對於編譯與建置時的時間影響(需要再載入龐大的Kotlin外掛包)，因此，Google建議使用Data-binding或View-binding為日後取得元件的方式。
            ↓↓↓↓↓↓↓↓↓↓↓↓
             */
                    ed_weight
        }

    fun bmi(view: View){
        val weight = ed_weight.text.toString().toFloat()
        val height = ed_height.text.toString().toFloat()
        val bmi = weight / (height * height)
        Log.d("BMI",bmi.toString())
    }

}