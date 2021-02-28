package com.thejoeun.studentlist_210221

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.thejoeun.studentlist_210221.adapters.StudentAdapter
import com.thejoeun.studentlist_210221.datas.Student
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

//    실제 학생들을 담아줄 목록 변수.
    val mStudentList = ArrayList<Student>()

//    리스트 뷰에 각각의 줄을 실제 뿌려줄 어댑터 변수
    lateinit var mAdapter : StudentAdapter   //변수인데 나중에 대입할 변수 (onCreate 실행 이후)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mStudentList.add(Student("조경진", 1988))
        mStudentList.add(Student("강서", 1990))
        mStudentList.add(Student("김윤", 1981))
        mStudentList.add(Student("박은", 1970))
        mStudentList.add(Student("신정", 1989))
        mStudentList.add(Student("오이", 1994))
        mStudentList.add(Student("이예", 1990))
        mStudentList.add(Student("이지", 1996))
        mStudentList.add(Student("채명", 1973))
        mStudentList.add(Student("최원", 1967))
        mStudentList.add(Student("최윤", 1987))


//        나중에 담아준다던 mAdapter에 실제 어댑터 대입
        mAdapter = StudentAdapter(this, R.layout.student_list_item, mStudentList)   // 이 화면에서 student_list_item 모양으로 mStudentList 을 뿌려라

//        리스트 뷰의 어댑터로써 => mAdapter를 지정
        studentListView.adapter = mAdapter

//        리스트 뷰의 각 줄이 눌렸을 경우 대처
        studentListView.setOnItemClickListener { parent, view, position, id ->

//        position : 몇 번 줄이 눌렷는지 알려줌.

//        클릭된 학생의 이름을 토스트로 출력
            val clickStudent = mStudentList[position]

            Toast.makeText(this, clickStudent.name, Toast.LENGTH_SHORT).show()


        }








    }
}