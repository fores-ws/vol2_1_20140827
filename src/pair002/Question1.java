package pair002;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * 素因数分解
 * @author r-ogata, r-mitsui
 */
public class Question1 {

	public static void main(String[] args) throws IOException {
		new Question1().execute();
	}

	/**
	 * 素因数分解
	 * @throws IOException
	 */
	private void execute() throws IOException {
		// 入力値
		long in = Long.parseLong(input());
		// 素数のリスト
		List<Long> primes = getPrimes(in);
		// 答えの文字列リスト
		List<String> answers = new ArrayList<String>();
		for (Long prime : primes) {
			// 割り切れなくなるまで割る
			Long count = 0L;
			while (true) {
				if (in % prime == 0) {
					count++;
					in /= prime;
					continue;
				}
				// 割り切れなかったらループを抜ける
				break;
			}
			// 一度も割り切れなかったら次の素数に移る
			if (count == 0) {
				continue;
			}
			answers.add(prime + "^" + count);
		}
		for (int i = 0; i < answers.size(); i++) {
			if (i != 0) {
				System.out.print(" x ");
			}
			System.out.print(answers.get(i));
		}
		System.out.println();
	}

	/**
	 * 素数を取得する
	 * 
	 * @param input
	 *            入力値
	 * @return 素数のリスト
	 */
	private List<Long> getPrimes(Long in) {
		List<Long> primes = new ArrayList<Long>();
		primes.add(2L);
		// 素数探しのループのときのキャッシュ
		List<Long> cache = new ArrayList<Long>();
		for (Long i = 3L; i < in + 1; i += 2) {
			boolean isPrime = true;
			for (Long cacheNumber : cache) {
				// 割り切れたら素数じゃない
				if (i % cacheNumber == 0) {
					isPrime = false;
					break;
				}
			}
			// 割り切れなかったら素数
			if (isPrime) {
				primes.add(i);
			}
			// あとのループのためキャッシュにも追加
			cache.add(i);
		}
		return primes;
	}

	/**
	 * 標準入力から文字列を取得する。
	 * 
	 * @return 文字列
	 * @throws IOException
	 */
	private String input() throws IOException {
		try (BufferedReader r = new BufferedReader(new InputStreamReader(
				System.in), 1024)) {
			return r.readLine();
		}
	}

}
