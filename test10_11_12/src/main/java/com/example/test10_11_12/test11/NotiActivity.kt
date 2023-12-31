package com.example.test10_11_12.test11

import android.app.DatePickerDialog
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Intent
import android.graphics.Color
import android.media.AudioAttributes
import android.media.RingtoneManager
import android.net.Uri
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.DatePicker
import androidx.core.app.NotificationCompat
import com.example.test10_11_12.databinding.ActivityNotiBinding

class NotiActivity : AppCompatActivity() {
    lateinit var binding: ActivityNotiBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNotiBinding.inflate(layoutInflater)
        setContentView(binding.root)

             //알림 설정, 기본1

        binding.button.setOnClickListener {
            DatePickerDialog(this, object : DatePickerDialog.OnDateSetListener {
                override fun onDateSet(p0: DatePicker?, p1: Int, p2: Int, p3: Int) {
                    Log.d("kkang", "year : $p1, month : ${p2 + 1}, dayOfMonth : $p3")
                }
            }, 2020, 8, 21).show()
        }
        binding.button.setOnClickListener {
            val manager = getSystemService(NOTIFICATION_SERVICE) as NotificationManager
            val builder: NotificationCompat.Builder

            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                val channelId = "one-channel"
                val channelName = "My Channel One"
                val channel = NotificationChannel(
                    channelId,
                    channelName,

                    //알림 소리, 알림의 중요도 옵션에 따라 일림음 여부가 결정되고,
                //현재 기본이 silent로 선택이 되어서, 디폴트 알림음으로 변경하면 알림음 확인
                    NotificationManager.IMPORTANCE_HIGH
                )
                //채널에 다양한 정보 설정
                channel.description = "My Channel One Description"
                //런처앱(여러 앱의 목록을 보여주는 액티비티)
                //해당 아이콘 상단에 알림 갯수등을 표시
                channel.setShowBadge(true)
                val uri: Uri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION)
                val audioAttributes = AudioAttributes.Builder()
                    .setContentType(AudioAttributes.CONTENT_TYPE_SONIFICATION)
                    .setUsage(AudioAttributes.USAGE_ALARM)
                    .build()
                //설정한 알림을 해당 채널에 적용하는 코드
                channel.setSound(uri, audioAttributes)
                //카메라 뒤에 후레쉬 led 색깔 표시 여부
                channel.enableLights(true)
                //led 색깔 옵션
                channel.lightColor = Color.RED
                //알림이 올 때 진동 여부 옵션
                channel.enableVibration(true)
                //알림이 왔을 때, 진동의 주기, 강도
                channel.vibrationPattern = longArrayOf(100, 200, 100, 200)
                //채널을 NotificationManager에 등록
                manager.createNotificationChannel(channel)

                //채널을 이용하여 builder 생성
                builder = NotificationCompat.Builder(this, channelId)
            } else {
                builder = NotificationCompat.Builder(this)
            }

            builder.setSmallIcon(android.R.drawable.ic_notification_overlay)
            builder.setWhen(System.currentTimeMillis())
            //더미 제목, 메시지가 나오지만, 네트워크 통신 라이브러리 이용해서, 실제 원격지에서 메시지를 가져오는 상황
            //우리는 중간에 메시지를 전달해주는 서버 : firebase에서 제공해주는 FCM 이용할 예정
            //FCM(Firebase

            builder.setContentTitle("Content Title")
            builder.setContentText("Content Massage")

            val intent = Intent(this@NotiActivity, detailActivity::class.java)
            val pendingIntent =
                PendingIntent.getActivity(this, 10, intent,
                    PendingIntent.FLAG_IMMUTABLE)
            builder.setContentIntent(pendingIntent)
            builder.setAutoCancel(true)


            manager.notify(11, builder.build())
        }
    }
}

