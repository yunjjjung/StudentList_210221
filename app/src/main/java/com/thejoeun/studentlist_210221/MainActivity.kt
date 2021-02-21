package com.thejoeun.studentlist_210221

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.thejoeun.studentlist_210221.datas.Student

class MainActivity : AppCompatActivity() {

//    실제 학생들을 담아줄 목록 변수.
    val mStudentList = ArrayList<Student>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mStudentList.add(Student("조경진", 1988))
        mStudentList.add(Student("강서", 1990))
        mStudentList.add(Student("김윤", 1981))
        mStudentList.add(Student("박은", 1981))
        mStudentList.add(Student("신정", 1970))
        mStudentList.add(Student("오이", 1989))
        mStudentList.add(Student("이예", 1989))
        mStudentList.add(Student("이지", 1989))
        mStudentList.add(Student("채명", 1989))
        mStudentList.add(Student("최원", 1967))
        mStudentList.add(Student("최윤", 1987))







    }
}