package rp.util;

/**
 * String comparator, to use in place of the bugged leJOS 0.9.1 String.compareTo method.
 * @author nah
 *
 */
public class StringComparator implements Comparator<String> {

	@Override
	public int compare(String _this, String _that) {
		int len1 = _this.length();
		int len2 = _that.length();

		int len = (len1 < len2) ? len1 : len2;

		for (int i = 0; i < len; i++) {
			char c1 = _this.charAt(i);
			char c2 = _that.charAt(i);

			if (c1 != c2) {
				return (c1 < c2) ? -1 : 1;
			}
		}

		if (len1 != len2) {
			return (len1 < len2) ? -1 : 1;
		}

		return 0;
	}

}
