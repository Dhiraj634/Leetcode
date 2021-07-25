import java.util.Arrays;

class Solution {
	int finalCompatibility;
	int taken[] = new int[8];
	int totalStudents, totalQuestion;
	public int maxCompatibilitySum(int[][] students, int[][] mentors) {
		this.finalCompatibility = 0;
		int m = students.length;
		int n = students[0].length;
		this.totalQuestion = n;
		this.totalStudents = m;
		Arrays.fill(this.taken,0);
		getMaxComp(students, mentors, 0, 0);
		return this.finalCompatibility;
	}
	private void getMaxComp(int [][]students, int[][] mentors, int m, int comp){
		if(m >= this.totalStudents){
			this.finalCompatibility = Math.max(this.finalCompatibility, comp);
			return;
		}
		for(int i=0;i< this.totalStudents;i++){
			if(taken[i] == 0){
				taken[i] = 1;
				int tempComp = getCompatibility(students[m], mentors[i]);
				getMaxComp(students,mentors, m+1,comp+tempComp);
				taken[i] = 0;
			}
		}
	}
	private int getCompatibility(int [] student, int []mentor){
		int count = 0;
		for(int i=0 ;i < student.length;i++){
			if(student[i] == mentor[i]){
				count++;
			}
		}
		return count;
	}
}