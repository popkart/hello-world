package queue;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Random;

/**
 * 一个学生排的队列里有男有女，现在要求男的排第一个，女的排第二个，接着排男的。。插花方式排队，而且男女还要按照以前的顺序来。
 * @author lz
 * @date 下午11:09:13
 */
public class SeparateQueue {

	public static void main(String[] args) {
		List<Student> originList = new ArrayList<Student>(){
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			
		};
		List<Student> resultList = new ArrayList<Student>(){
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

		
		};
		for (int i = 0; i < 100; i++) {
			Random r = new Random();
			originList.add(new Student(i, r.nextBoolean()));
		}
		
		System.out.println(originList.toString());
		Queue<Student> maleQueue = new LinkedList<Student>();
		Queue<Student> femaleQueue = new LinkedList<Student>();

		boolean acceptStatus = true;
		for (Student s : originList) {
			Queue<Student> currentQueue = s.sex ? maleQueue : femaleQueue;
			Queue<Student> oppositeQueue = s.sex ? femaleQueue : maleQueue;
			if (s.sex == acceptStatus) {
				resultList.add(s);
				acceptStatus = !acceptStatus;
				if(!oppositeQueue.isEmpty()){
					resultList.add(oppositeQueue.remove());
					acceptStatus = !acceptStatus;
				}
			} else {
				currentQueue.add(s);
			}
		}
		if(acceptStatus){
			resultList.addAll(femaleQueue);
		} else {
			resultList.addAll(maleQueue);
		}
		System.out.println(resultList.toString());
	}
}

class Student {
	int id;
	boolean sex;
	String name;

	public Student(int id, boolean sex) {
		this.id = id;
		this.sex = sex;
	}

	@Override
	public String toString() {
		return new Integer(id).toString() + new Boolean(sex).toString();
	}
}