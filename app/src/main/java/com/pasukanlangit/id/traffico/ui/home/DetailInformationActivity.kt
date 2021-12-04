package com.pasukanlangit.id.traffico.ui.home

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.pasukanlangit.id.traffico.R
import com.pasukanlangit.id.traffico.databinding.ActivityDetailInformationBinding
import com.pasukanlangit.id.traffico.model.Information
import android.content.Intent
import android.net.Uri


class DetailInformationActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetailInformationBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailInformationBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.iconBack.setOnClickListener { this.finish() }

        intent.getParcelableExtra<Information>(KEY_INFORMATION)?.let { information ->
            with(binding){
                tvDesc.text = "Pembuatan ${information.sim}"
                ivImgDetail.setImageResource(information.detailImg)
                tvDescDetail.text = getString(R.string.text_description_information, information.sim, information.desc)
                tvRequirements.text = information.requirement

                btnInternet.setOnClickListener {
                    startActivity(
                        Intent(
                            Intent.ACTION_VIEW,
                            Uri.parse(information.url)
                        )
                    )
                }
            }


        }

        binding.btnBack.setOnClickListener { this.finish() }
    }

    companion object {
        const val KEY_INFORMATION = "KEY_INFORMATION"
    }
}