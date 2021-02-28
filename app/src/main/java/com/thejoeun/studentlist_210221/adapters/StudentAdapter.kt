package com.thejoeun.studentlist_210221.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.CalendarView
import android.widget.TextView
import com.thejoeun.studentlist_210221.R
import com.thejoeun.studentlist_210221.datas.Student
import java.util.*
import kotlin.collections.ArrayList

class StudentAdapter(
    val mContext : Context,     //어떤 화면 , 액티비티가 어딘지
    val resId : Int,    // xml 모양이 어떻게 생겻는지
    val mList : ArrayList<Student>) : ArrayAdapter<Student>(mContext, resId, mList) {   //자바에 상속 개념

//    student_list_item xml을 가지고 => 코틀린에서 다룰 수 있게 도와주는 변수. (inf)클래스 (LayoutInflater)
    val inf = LayoutInflater.from(mContext)

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {  //position이라는 변수를 Int로 데려옴
                                                                                    // View? 아직 정확치 않다. 현재 null

        var tempRow = convertView   //임시로 한칸을 그려넣겠다

        if(tempRow == null) {
            tempRow = inf.inflate(R.layout.student_list_item, null) // inflate가 한번 실행될 때 마다 View가 하나 배치됨
        }

        val row = tempRow!! //절대로 안 비어있어

//        화면에 뿌려지는 row를 일부 수정하고 나서 => return 되도록.
//        몇번째 줄에 뿌릴 row인지 파악하고 상황에 맞게 가공.
//        mList에서 위치에 맞는 학생을 먼저 추출.

        val student = mList[position]

//        raw변수 (XML모양)에서 => 필요한 텍스트뷰/이미지뷰를 꺼내오자 (수기작업)

        val nameTxt = row.findViewById<TextView>(R.id.nameTxt)
        val ageTxt = row.findViewById<TextView>(R.id.ageTxt)

//        Student의 값을 => 텍스트뷰들에 반영

        nameTxt.text = student.name

//        현재 나이를 구해서 반영 => 현재년도 - 출생년도 + 1
//        자바의 Calendar 객체 생성 => 기본값 : 현재 일시
//        cal 에서 년도값을 추출 => 현재 년도.
        val cal = Calendar.getInstance()

        val age = cal.get(Calendar.YEAR) - student.birthYear + 1

        ageTxt.text = "(${age}세)"


        return row
    }

}