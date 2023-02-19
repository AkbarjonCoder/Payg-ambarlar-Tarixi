package com.tarix.paygambarlartarixi

import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.widget.SeekBar
import org.koin.androidx.viewmodel.ext.android.viewModel
import com.tarix.paygambarlartarixi.room.Data
import com.tarix.paygambarlartarixi.room.ViewModel
import uz.tarix.paygambarlartarixi.R
import uz.tarix.paygambarlartarixi.databinding.ActivityAudioBinding
import java.text.SimpleDateFormat
import java.util.*
import kotlin.collections.ArrayList

class AudioActivity : AppCompatActivity(), MediaPlayer.OnPreparedListener,
    SeekBar.OnSeekBarChangeListener {

    private val binding by lazy { ActivityAudioBinding.inflate(layoutInflater) }
    private var mediaPlayer: MediaPlayer? = null

    private lateinit var handler: Handler

    private var musics = ArrayList<Int>()

    private var isPlaying = false
    private val viewModel : ViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        var positon = intent.getStringExtra("position").toString().toInt()

        binding.btnPlay.setBackgroundResource(R.drawable.ic_baseline_play_circle_filled_24)

        musics.add(R.raw.odam)
        musics.add(R.raw.idris)
        musics.add(R.raw.nuh)
        musics.add(R.raw.hud)
        musics.add(R.raw.solih)
        musics.add(R.raw.ibrohim)
        musics.add(R.raw.lut)
        musics.add(R.raw.ismoil)
        musics.add(R.raw.isxoq)
        musics.add(R.raw.yaqub)
        musics.add(R.raw.yusuf)
        musics.add(R.raw.ayyub)
        musics.add(R.raw.shuayb)
        musics.add(R.raw.muso)
        musics.add(R.raw.horun)
        musics.add(R.raw.yunus)
        musics.add(R.raw.dovud)
        musics.add(R.raw.sulaymon)
        musics.add(R.raw.ilyos)
        musics.add(R.raw.alyasa)
        musics.add(R.raw.zakariyo)
        musics.add(R.raw.iso)
        musics.add(R.raw.muhammad)

        handler = Handler(mainLooper)

        val intent = intent
        val title = intent?.getStringExtra("title")
        val number = intent?.getStringExtra("number")
        mediaPlayer = MediaPlayer.create(this, musics[positon])
        binding.namee.text = title
        binding.end.text = number

        binding.btnPlay.setOnClickListener {
            if (isPlaying){
                isPlaying = false
                mediaPlayer!!.pause()

                binding.btnPlay.setBackgroundResource(R.drawable.ic_baseline_play_circle_filled_24)
                binding.imageView.animate().rotation(binding.imageView.rotation).duration = 0
            }
            else{
                circle()
                isPlaying = true

                mediaPlayer?.start()

                binding.seekBar.max = mediaPlayer?.duration!!
                handler.postDelayed(runnable, 100)

                binding.btnPlay.setBackgroundResource(R.drawable.ic_baseline_pause_circle_filled_24)
            }
        }

//        binding.btnPlay.setOnClickListener{
//            if (mediaPlayer != null) {
//                if (mediaPlayer?.isPlaying!!)
//                    mediaPlayer?.pause()
//                binding.btnPlay.setBackgroundResource(R.drawable.ic_baseline_play_circle_filled_24)
//            }
//
//        }
//        binding.btnPlay.setOnClickListener{
//            if (mediaPlayer != null) {
//                if (!mediaPlayer?.isPlaying!!)
//                    mediaPlayer?.start()
//                binding.btnPlay.setBackgroundResource(R.drawable.ic_baseline_pause_circle_filled_24)
//            }
//
//        }

        binding.forward.setOnClickListener {
            mediaPlayer?.seekTo(mediaPlayer?.currentPosition?.plus(3000)!!)
        }

        binding.arrow.setOnClickListener {
            mediaPlayer?.seekTo(mediaPlayer?.currentPosition?.minus(3000)!!)
        }

        binding.seekBar.setOnSeekBarChangeListener(this)

        binding.imageFavourite.setOnClickListener {
            viewModel.insertData(Data(R.drawable.islam,"$title","$number",positon))
        }

    }

    fun circle(){
        binding.imageView.animate().rotation(binding.imageView.rotation+360f).setDuration(15000).withEndAction{
            circle()
        }
    }

    override fun onPrepared(md: MediaPlayer?) {
        md?.start()
        binding.end.text = displayTime(mediaPlayer?.duration!!.toLong())
        binding.seekBar.max = mediaPlayer?.duration!!
        handler.postDelayed(runnable, 100)
    }

    override fun onDestroy() {
        super.onDestroy()
        try {
            if (mediaPlayer != null) {
                mediaPlayer?.release()
                mediaPlayer = null
            }
        }catch (e: Exception) {
            e.printStackTrace()
        }
    }

    private var runnable = object : Runnable {
        override fun run() {
            try {
                handler.postDelayed(this, 100)
                binding.seekBar.progress = mediaPlayer?.currentPosition!!
                binding.start.text = displayTime(mediaPlayer?.currentPosition!!.toLong())
            }catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }

    private fun displayTime(pos: Long): String {
        val dateFormat = SimpleDateFormat("mm:ss", Locale.getDefault())
        return dateFormat.format(pos)
    }

    override fun onProgressChanged(seekBar: SeekBar?, pos: Int, fromUser: Boolean) {
        if (fromUser) {
            binding.start.text = displayTime(pos.toLong())
            seekBar?.let{
                mediaPlayer?.seekTo(it.progress)
            }
        }
    }

    override fun onStartTrackingTouch(p0: SeekBar?) {
    }

    override fun onStopTrackingTouch(seekBar: SeekBar?) {
    }

}