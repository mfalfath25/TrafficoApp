package com.pasukanlangit.id.traffico.ui.profile

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.pasukanlangit.id.traffico.databinding.ActivityEditProfileBinding
import com.pasukanlangit.id.traffico.model.ProfileModel

class EditProfileActivity : AppCompatActivity() {
    private lateinit var binding: ActivityEditProfileBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEditProfileBinding.inflate(layoutInflater)
        setContentView(binding.root)

        intent.getParcelableExtra<ProfileModel>(KEY_PROFILE)?.let { profile ->
            with(binding){
                edtImg.setText(profile.imgUrl)
                edtName.setText(profile.name)
            }
        }

        binding.btnSave.setOnClickListener {
            val edittextName = binding.edtName.text.toString().trim()
            val imgUrl = binding.edtImg.text.toString().trim()
            if(edittextName.isEmpty()){
                Toast.makeText(this, "Nama tidak boleh kosong", Toast.LENGTH_SHORT).show()
            }else{
                val intent = Intent()
                intent.putExtra(KEY_PROFILE, ProfileModel(
                    imgUrl = imgUrl,
                    name = edittextName
                ))
                setResult(RESULT_OK, intent)
                finish()
            }
        }
    }

    companion object {
        const val KEY_PROFILE = "KEY_PROFILE"
    }
}