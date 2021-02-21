package com.thejoeun.studentlist_210221.adapters

import android.content.Context
import android.widget.ArrayAdapter
import com.thejoeun.studentlist_210221.datas.Student

class StudentAdapter(
    val mContext : Context,     //어떤 화면 , 액티비티가 어딘지
    val resId : Int,    // xml 모양이 어떻게 생겻는지
    val mList : ArrayList<Student>) : ArrayAdapter<Student>(mContext, resId, mList) {   //자바에 상속 개념

}