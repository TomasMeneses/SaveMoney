package com.example.tomas.savemoney

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

class DespesasAdapter: RecyclerView.Adapter<CustomViewHolder>(){

    //numero de itens a serem exibidos por vez
    override fun getItemCount(): Int {
        return 7
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomViewHolder {
        //Como criamos a view
        val layoutInflater = LayoutInflater.from(parent?.context)
        val cellForRow = layoutInflater.inflate(R.layout.despesas_row, parent, false)
        return CustomViewHolder(cellForRow)
    }

    override fun onBindViewHolder(holder: CustomViewHolder?, position: Int) {

    }
}

class CustomViewHolder(v: View): RecyclerView.ViewHolder(v){

}