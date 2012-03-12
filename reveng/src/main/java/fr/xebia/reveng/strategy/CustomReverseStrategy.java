package fr.xebia.reveng.strategy;

import org.hibernate.cfg.reveng.DelegatingReverseEngineeringStrategy;
import org.hibernate.cfg.reveng.ReverseEngineeringStrategy;
import org.hibernate.cfg.reveng.TableIdentifier;

import com.google.common.base.Strings;

/**
 * @author tomtom
 * 
 */
public class CustomReverseStrategy extends DelegatingReverseEngineeringStrategy {

    /**
     * Constructor
     * 
     * @param delegate
     *            {@link org.hibernate.cfg.reveng.ReverseEngineeringStrategy}
     */
    public CustomReverseStrategy(ReverseEngineeringStrategy delegate) {
	super(delegate);
    }

    private static final String TABLE_PREFIX = "T_";

    @Override
    public String tableToClassName(TableIdentifier tableIdentifier) {
	String defaultName = super.tableToClassName(tableIdentifier);

	String tableName = tableIdentifier.getName();
	String qualifiedClassName = defaultName;
	if (tableName.startsWith(TABLE_PREFIX)) {
	    qualifiedClassName = retrieveQualifiedClassNameWithoutTablePrefix(defaultName);
	}

	return qualifiedClassName;
    }

    private String retrieveQualifiedClassNameWithoutTablePrefix(
	    String qualifiedClassName) {

	if (Strings.isNullOrEmpty(qualifiedClassName)) {
	    return qualifiedClassName;
	}

	return removeTablePrefixOfQualifiedClassName(qualifiedClassName);
    }

    private String removeTablePrefixOfQualifiedClassName(
	    String qualifiedClassNameWithPrefix) {
	int indexOfLastDot = qualifiedClassNameWithPrefix.lastIndexOf(".");
	String classNameWithoutPrefix = qualifiedClassNameWithPrefix.substring(
		indexOfLastDot + 2, qualifiedClassNameWithPrefix.length());
	String packageName = qualifiedClassNameWithPrefix.substring(0,
		indexOfLastDot + 1);
	return packageName + classNameWithoutPrefix;
    }
}
