package uz.vianet.viewbindingmvvm.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import androidx.lifecycle.ViewModelProvider
import uz.vianet.viewbindingmvvm.databinding.ActivityDetailsBinding
import uz.vianet.viewbindingmvvm.viewmodel.DetailViewModel

class DetailsActivity : AppCompatActivity() {
    lateinit var binding: ActivityDetailsBinding
    lateinit var viewModel: DetailViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailsBinding.inflate(LayoutInflater.from(this))
        setContentView(binding.root)
        initViews()
    }

    private fun initViews() {
        viewModel = ViewModelProvider(this)[DetailViewModel::class.java]
        val extras = intent.extras
        if (extras != null) {
            Log.d("###", "extras not NULL - ")
            val id = extras.getInt("id")
            viewModel.apiPostDetail(id)
            viewModel.detailPost.observe(this){
                binding.tvTitle.setText(it.title.uppercase())
                binding.tvBody.setText(it.body)
            }

        }
    }
}