package com.thejoeun.studentlist_210221

import android.app.Dialog
import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
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

//            true : 롱 클릭 전용, false : 전용 X , 일반클릭도 처리
        studentListView.setOnItemLongClickListener { parent, view, position, id ->

            /*val std = mStudentList[position]
            Toast.makeText(this, "${std.name} 길게 눌림", Toast.LENGTH_SHORT).show()*/

//            진짜 삭제를 진행하기 전에, 정말 지울건지 물어보고 진행

            val alert = AlertDialog.Builder(this)
            alert.setTitle("삭제 확인")
            alert.setMessage("정말 해당 학생을 삭제하시겠습니까?")
            alert.setPositiveButton("확인", DialogInterface.OnClickListener { dialog, which ->

                mStudentList.removeAt(position)

                mAdapter.notifyDataSetChanged()
            })

            alert.setNegativeButton("취소", null)
            alert.show()

            return@setOnItemLongClickListener false

        }








    }
}