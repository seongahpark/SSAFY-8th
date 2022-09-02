package basic;

public class Basic_Delta {

	static int dx[] = { 0, 0, -1, 1};
	static int dy[] = {-1, 1, 0, 0};
	
	public static void main(String[] args) {
		int [][] input = {
				{ 1, 2, 3, 4},
				{5, -1, 7, 8},
				{9, 10, 11, 12},
				{13, 14, 15, 16}
		};

		int res = 0;
		for(int y=0; y<4; y++) {
			for(int x=0; x<4; x++) {
				if(input[y][x] == -1) {
					// 4방 탐색
					for(int z = 0; z<4; z++) {
						int nx = y;
						int ny = x;
						
						while(true) {
							ny += dy[z];
							nx += dx[z];
							
							if(nx < 0 || ny < 0 || nx >= 4 || ny >= 4) break;
							System.out.printf("%3d", input[ny][nx]);
						}
						
						System.out.println();
						
					}
				}
			}
		}
	}

}
