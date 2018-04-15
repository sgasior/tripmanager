package pl.edu.agh.mwo;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.theories.Theories;

public class PhotoTest {
	Photo thePhoto;

	@Before
	public void createEmptyPhotoForTheTest() {
		thePhoto = new Photo("Kraków-Wawel");
	}

	@Test
	public void testPhotoCtorIsCorrect() {
		Assert.assertEquals("Kraków-Wawel", thePhoto.comment());
	}

}
