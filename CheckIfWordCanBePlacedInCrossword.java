import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Solution {
	public boolean placeWordInCrossword(char[][] board, String word) {
		HashSet<String> map = new HashSet<>();
		int m = board.length;
		int n = board[0].length;
		for(int i= 0;i<m;i++){
			StringBuilder sb = new StringBuilder();
			for(int j=0;j<n;j++){
				if(board[i][j] == ' '){
					sb.append('.');
				}
				else {
					sb.append(board[i][j]);
				}
			}
			map.addAll(Arrays.asList(sb.toString().split("#")));
			map.addAll(Arrays.asList(sb.reverse().toString().split("#")));
		}
		for(int i= 0;i<n;i++){
			StringBuilder sb = new StringBuilder();
			for(int j=0;j<m;j++){
				if(board[j][i] == ' '){
					sb.append('.');
				}
				else{
					sb.append(board[j][i]);
				}
			}
			map.addAll(Arrays.asList(sb.toString().split("#")));
			map.addAll(Arrays.asList(sb.reverse().toString().split("#")));
		}
		for(String str: map){
			Pattern p = Pattern.compile(str);
			Matcher matcher = p.matcher(word);
			if(matcher.matches()){
				return true;
			}
		}
		return false;
	}
}