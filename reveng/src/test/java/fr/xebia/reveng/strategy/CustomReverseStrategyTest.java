/**
 * 
 */
package fr.xebia.reveng.strategy;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import org.hibernate.cfg.reveng.ReverseEngineeringStrategy;
import org.hibernate.cfg.reveng.TableIdentifier;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

/**
 * @author tomtom
 * 
 */
@RunWith(MockitoJUnitRunner.class)
public class CustomReverseStrategyTest {

    private static final String MODEL_PACKAGE = "fr.xebia.reveng.model.";

    @Mock
    private ReverseEngineeringStrategy reverseEngineeringStrategy;

    @Mock
    private TableIdentifier tableIdentifier;

    private CustomReverseStrategy customReverseStrategy;

    @Before
    public void setUp() {
	customReverseStrategy = new CustomReverseStrategy(
		reverseEngineeringStrategy);
    }

    @Test
    public void should_removeT_Prefix() {

	// Given
	when(reverseEngineeringStrategy.tableToClassName(tableIdentifier))
		.thenReturn(MODEL_PACKAGE + "TTest");
	when(tableIdentifier.getName()).thenReturn("T_TEST");

	// When
	String className = customReverseStrategy
		.tableToClassName(tableIdentifier);

	// Then
	assertEquals(MODEL_PACKAGE + "Test", className);
    }
}
