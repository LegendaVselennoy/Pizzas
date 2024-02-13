package com.hfad.bitsandpizzas

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RadioGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.appbar.MaterialToolbar
import com.google.android.material.chip.Chip
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import com.hfad.bitsandpizzas.databinding.FragmentOrderBinding

class OrderFragment : Fragment() {

    private var _binding:FragmentOrderBinding?=null;
    private val binding get()=_binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
//        val view= inflater.inflate(R.layout.fragment_order, container, false)
        _binding=FragmentOrderBinding.inflate(inflater,container,false)
        val view=binding.root

//        val toolbar=view.findViewById<MaterialToolbar>(R.id.toolbar)
        (activity as AppCompatActivity).setSupportActionBar(binding.toolbar)

//        val fab=view.findViewById<FloatingActionButton>(R.id.fab)
       binding.fab.setOnClickListener {
//            val pizzaGroup=view.findViewById<RadioGroup>(R.id.pizza_group)
            val pizzaType=binding.pizzaGroup.checkedRadioButtonId
            if (pizzaType==-1){
                val text="Вам нужно выбрать тип пиццы"
                Toast.makeText(activity,text,Toast.LENGTH_LONG).show()
            }else{
                var text=(when(pizzaType){
                    R.id.radio_dia->"Острая пицца"
                    else->"Грибная пицца"
                })

//                val parmesan=view.findViewById<Chip>(R.id.parmesan)
                text+=if (binding.parmesan.isChecked) ", дополнительно пармезан" else ""
//                val chiliOil=view.findViewById<Chip>(R.id.chili_oil)
                text+=if (binding.chiliOil.isChecked) ", дополнительно чили соус" else ""
                Snackbar.make(binding.fab,text,Snackbar.LENGTH_LONG).show()
            }
        }
        return view
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding=null
    }

}