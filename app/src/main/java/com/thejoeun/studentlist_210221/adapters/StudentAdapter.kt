package com.thejoeun.studentlist_210221.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import com.thejoeun.studentlist_210221.R
import com.thejoeun.studentlist_210221.datas.Student

class StudentAdapter(
    val mContext : Context,     //어떤 화면 , 액티비티가 어딘지
    val resId : Int,    // xml 모양이 어떻게 생겻는지
    val mList : ArrayList<Student>) : ArrayAdapter<Student>(mContext, resId, mList) {   //자바에 상속 개념

//    student_list_item xml을 가지고 => 코틀린에서 다룰 수 있게 도와주는 변수. (inf)클래스 (LayoutInflater)
    val inf = LayoutInflater.from(mContext)

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {

        var tempRow = convertView   //임시로 한칸을 그려넣겠다

        if(tempRow == null) {
            tempRow = inf.inflate(R.layout.student_list_item, null)
        }

        val row = tempRow!! //절대로 안 비어있어

        return row
    }

}