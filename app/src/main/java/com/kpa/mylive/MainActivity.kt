package com.kpa.mylive

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.kpa.mylive.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private val TAG = this.javaClass.simpleName


    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Example of a call to a native method
        binding.sampleText.text = "当前版本 ：" + getFFmpegVersion()
        /** 1\. Java 数据传递给 native  */
//        test(
//            true,
//            1.toByte(),
//            ',',
//            3.toShort(),
//            4,
//            3.3f,
//            2.2,
//            "MyLive",
//            28, intArrayOf(1, 2, 3, 4, 5, 6, 7), arrayOf("1", "2", "4"),
//            Person("平安", 27), booleanArrayOf(false, true)
//        )
//        dynamicRegister("我是动态注册的")
//        dynamicRegister1("异常处理")
    }

//    /**
//     * A native method that is implemented by the 'mylive' native library,
//     * which is packaged with this application.
//     */
//    external fun stringFromJNI(): String
//
//    /**
//     * 动态注册JNI
//     */
//    external fun dynamicRegister(name: String)
//
//    /**
//     * 异常处理
//     */
//    external fun dynamicRegister1(name: String)
//
//    @Throws(NullPointerException::class)
//    private fun testException() {
//        throw NullPointerException("自定义异常")
//    }
//
//    private external fun test(
//        b: Boolean, b1: Byte, c: Char, s: Short,
//        l: Long,
//        f: Float,
//        d: Double,
//        name: String,
//        age: Int,
//        i: IntArray, strs: Array<String>, person: Person,
//        bArray: BooleanArray
//    )
//
//    private external fun getPerson(): Person
//
//    /**
//     * 测试局部引用
//     */
//    private external fun testLocalReference()
//
//    private external fun nativeCount()


    private external fun getFFmpegVersion(): String

    companion object {
        init {
            System.loadLibrary("ffmpeg_lib")
        }
    }

    var count = 0

//    fun testLocalReference(view: View) {
//        for (i in 0..10) {
//            thread {
//                count()
//                nativeCount()
//            }
//        }
//        nativeCount()
//    }

    private fun count() {
        synchronized(this) {
            count++
            Log.d("Java", "count " + count)
        }
    }
}