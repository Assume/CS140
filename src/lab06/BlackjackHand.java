package lab06;

public class BlackjackHand extends CardHand {

	@Override
	public int value() {
		int tot = 0;
		boolean has_ace = false;
		for (Card x : cards)
			if (x.getValue() == 11)
				has_ace = true;
			else
				tot += x.getValue();

		if (has_ace)
			for (Card x : cards)
				if (x.getValue() != 11)
					continue;
				else
					tot += tot + 11 > 21 ? 1 : 11;
		return tot;

	}

}
