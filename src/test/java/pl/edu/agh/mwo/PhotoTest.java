package pl.edu.agh.mwo;

import org.junit.Assert;
import org.junit.Test;

public class PhotoTest {

	@Test
	public void testPhotoCtorIsCorrect() {
		Photo thePhoto = new Photo("Kraków-Wawel");
		Assert.assertEquals("Kraków-Wawel", thePhoto.comment());
	}

	@Test(expected = IllegalArgumentException.class)
	public void testPhotoWithNullComment() {
		Photo thePhoto = new Photo(null);

	}

	@Test(expected = IllegalArgumentException.class)
	public void testPhotoWithEmptyComment() {
		Photo thePhoto = new Photo("");

	}

}
