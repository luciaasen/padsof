/**
 * 
 */
package moon.course.tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import moon.course.Course;
import moon.course.Exercise;
import moon.course.Unit;

/**
 * This is a test class for Unit.
 * @author Juan Riera and Lucia Asencio
 *
 */
public class UnitTest {
	
	Unit u1;
	Unit u2;
	Unit u3;
	Unit u4;
	Exercise e1, e2, e3, e4;
	Course c1, c2;
	/**
	 * Here we set up four units:
	 * 		u1 will be part of the course c1
	 * 		u2 will be part of the course c1
	 * 		u3 will be part of the course c2
	 * 		u4 will be part of the course c2
	 * 
	 * We also create some exercises to fill the units, but
	 * we could have used any course element instead.
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		u1 = new Unit("Unit 1 course 1");
		u2 = new Unit("Unit 2 course 1");
		u3 = new Unit("Unit 1 course 2");
		u4 = new Unit("Unit 2 course 2");
		
		c1 = new Course("Course in applied methematics");
		c2 = new Course("Course in understanding");
		u1.setCourse(c1);
		u2.setCourse(c1);
		u3.setCourse(c2);
		u4.setCourse(c2);
		
		e1 = new Exercise();
		e2 = new Exercise();
		e3 = new Exercise();
		e4 = new Exercise();
		
	}

	/**
	 * Test method for {@link moon.course.Unit#Unit(java.lang.String)}.
	 */
	@Test
	public void testUnit() {
		/* Let's start checking that none if the units is null */
		assertNotNull(u1);
		assertNotNull(u2);
		assertNotNull(u3);
		assertNotNull(u4);
		
		/* Now let's check that they have been properly initialized */
		assertEquals(u1.getName(), "Unit 1 course 1");
		assertEquals(u2.getName(), "Unit 2 course 1");
		assertEquals(u3.getName(), "Unit 1 course 2");
		assertEquals(u4.getName(), "Unit 2 course 2");
		
	}
	
	/**
	 * Test method for {@link moon.course.Unit#setCourse(moon.course.Course)}.
	 * Here we change some of the  course-unit assignations. After checking that
	 * the associations  between them have been properly initialized in the setup
	 * we change some of them to a different ones, and re-check.
	 */
	@Test
	public void testSetCourse() {
		assertEquals(u1.getCourse(), c1);
		assertEquals(u2.getCourse(), c1);
		assertEquals(u3.getCourse(), c2);
		assertEquals(u4.getCourse(), c2);
		
		u1.setCourse(c2);
		u2.setCourse(c1);
		u3.setCourse(c1);
		u4.setCourse(c2);
		
		assertEquals(u1.getCourse(), c2);
		assertEquals(u2.getCourse(), c1);
		assertEquals(u3.getCourse(), c1);
		assertEquals(u4.getCourse(), c2);
	}



	/**
	 * Test method for {@link moon.course.Unit#addElement(moon.course.CourseElement)}.,
	 * {@link moon.course.Unit#removeElement(moon.course.CourseElement)}. and
	 * {@link moon.course.Unit#getContents()}.
	 */
	@Test
	public void testAddAndRemoveElementAndGetContents() {
		/* We start checking that none of the units has elements */
		assertTrue(u1.getContents().size()==0);
		assertTrue(u2.getContents().size()==0);
		assertTrue(u3.getContents().size()==0);
		assertTrue(u4.getContents().size()==0);
		
		/* No we'll add some elements to the units */
		assertTrue(u1.addElement(e1));
		assertTrue(u1.addElement(e2));
		assertTrue(u1.addElement(e3));
		assertTrue(u2.addElement(e4));
		assertFalse(u1.addElement(e1));
		
		/* Now let's check that they have been added properly */
		assertTrue(u1.getContents().size()==3);
		assertTrue(u1.getContents().contains(e1));
		assertTrue(u1.getContents().contains(e2));
		assertTrue(u1.getContents().contains(e3));
		assertTrue(u2.getContents().contains(e4));
		assertTrue(u2.getContents().size()==1);
		assertTrue(u3.getContents().size()==0);
		assertTrue(u4.getContents().size()==0);
		
		/* Now we'll remove some of them*/
		assertTrue(u1.removeElement(e1));
		assertFalse(u1.removeElement(e1));
		assertFalse(u1.removeElement(e4));
		assertTrue(u2.removeElement(e4));
		
		/* Last re-check */
		assertTrue(u1.getContents().size()==2);
		assertFalse(u1.getContents().contains(e1));
		assertTrue(u1.getContents().contains(e2));
		assertTrue(u1.getContents().contains(e3));
		assertTrue(u2.getContents().size()==0);
		assertTrue(u3.getContents().size()==0);
		assertTrue(u4.getContents().size()==0);
		
	}

	/**
	 * Test method for {@link moon.course.Unit#getName()}.and {@link moon.course.Unit.setName()}
	 */
	@Test
	public void testGetAndSetName() {
		assertEquals(u1.getName(), "Unit 1 course 1");
		assertEquals(u2.getName(), "Unit 2 course 1");
		
		u1.setName("New Unit 1");
		u2.setName("New Unit 2");
		
		assertEquals(u1.getName(), "New Unit 1");
		assertEquals(u2.getName(), "New Unit 2");
	}


	/**
	 * Test method for {@link moon.course.CourseElement#setUnit(moon.course.Unit)}, 
	 * {@link moon.course.CourseElement#getUnit()} and {@link moon.course.CourseElement#getCourse()}
	 */
	@Test
	public void testSetAndGetUnitAndGetCourse() {
		
		/* We make sure that the associations have been properly made 
		 * in the set up */
		assertEquals(u1.getCourse(), c1);
		assertEquals(u2.getCourse(), c1);
		assertEquals(u3.getCourse(), c2);
		assertEquals(u4.getCourse(), c2);
		
		/* Now let's put some units in other units, and change the course
		 * of a unit. It is important to note that these will not be possible
		 * to be done with the interface. */
		u2.setCourse(c2);
		e1.setUnit(u1);
		e2.setUnit(u2);
		u3.setUnit(u1);
		u4.setUnit(u2);
		
		/* Now let's re-check that everything was properly done */
		assertEquals(u1.getCourse(), c1);
		assertEquals(u3.getCourse(), c1);
		assertEquals(u2.getCourse(), c2);
		assertEquals(u4.getCourse(), c2);
		
		
	}

}
