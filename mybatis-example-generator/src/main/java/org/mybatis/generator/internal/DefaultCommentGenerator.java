package org.mybatis.generator.internal;

import org.mybatis.generator.api.CommentGenerator;
import org.mybatis.generator.api.IntrospectedColumn;
import org.mybatis.generator.api.IntrospectedTable;
import org.mybatis.generator.api.dom.java.CompilationUnit;
import org.mybatis.generator.api.dom.java.Field;
import org.mybatis.generator.api.dom.java.InnerClass;
import org.mybatis.generator.api.dom.java.InnerEnum;
import org.mybatis.generator.api.dom.java.JavaElement;
import org.mybatis.generator.api.dom.java.Method;
import org.mybatis.generator.api.dom.java.Parameter;
import org.mybatis.generator.api.dom.xml.TextElement;
import org.mybatis.generator.api.dom.xml.XmlElement;
import org.mybatis.generator.internal.util.StringUtility;

import java.util.Date;
import java.util.Properties;


public class DefaultCommentGenerator
        implements CommentGenerator {
    private Properties properties;
    private boolean suppressDate;
    private boolean suppressAllComments;

    public DefaultCommentGenerator() {
/*  51 */
        this.properties = new Properties();
/*  52 */
        this.suppressDate = false;
/*  53 */
        this.suppressAllComments = false;
    }


    public void addJavaFileComment(CompilationUnit compilationUnit) {
    }


    public void addComment(XmlElement xmlElement) {
/*  66 */
        if (this.suppressAllComments) {
/*  67 */
            return;
        }
     
/*  70 */
        xmlElement.addElement(new TextElement("<!--"));
     
/*  72 */
        StringBuilder sb = new StringBuilder();
/*  73 */
        sb.append("  WARNING - ");
/*  74 */
        sb.append("@mbggenerated");
/*  75 */
        xmlElement.addElement(new TextElement(sb.toString()));
/*  76 */
        xmlElement.addElement(new TextElement("  This element is automatically generated by MyBatis Generator, do not modify."));
     
 
 
/*  80 */
        String s = getDateString();
/*  81 */
        if (s != null) {
/*  82 */
            sb.setLength(0);
/*  83 */
            sb.append("  This element was generated on ");
/*  84 */
            sb.append(s);
/*  85 */
            sb.append('.');
/*  86 */
            xmlElement.addElement(new TextElement(sb.toString()));
        }
     
/*  89 */
        xmlElement.addElement(new TextElement("-->"));
    }


    public void addRootComment(XmlElement rootElement) {
    }


    public void addConfigurationProperties(Properties properties) {
/*  98 */
        this.properties.putAll(properties);

        this.suppressDate = StringUtility.isTrue(properties.getProperty("suppressDate"));


        this.suppressAllComments = StringUtility.isTrue(properties.getProperty("suppressAllComments"));
    }


    protected void addJavadocTag(JavaElement javaElement, boolean markAsDoNotDelete) {
        javaElement.addJavaDocLine(" *");
        StringBuilder sb = new StringBuilder();
        sb.append(" * ");
        sb.append("@mbggenerated");
        if (markAsDoNotDelete) {
            sb.append(" do_not_delete_during_merge");
        }
        String s = getDateString();
        if (s != null) {
            sb.append(' ');
            sb.append(s);
        }
        javaElement.addJavaDocLine(sb.toString());
    }


    protected String getDateString() {
        if (this.suppressDate) {
            return null;
        }
        return new Date().toString();
    }


    public void addClassComment(InnerClass innerClass, IntrospectedTable introspectedTable) {
        if (this.suppressAllComments) {
            return;
        }

        StringBuilder sb = new StringBuilder();

        innerClass.addJavaDocLine("/**");
        innerClass.addJavaDocLine(" * This class was generated by MyBatis Generator.");


        sb.append(" * This class corresponds to the database table ");
        sb.append(introspectedTable.getFullyQualifiedTable());
        innerClass.addJavaDocLine(sb.toString());

        addJavadocTag(innerClass, false);

        innerClass.addJavaDocLine(" */");
    }

    public void addEnumComment(InnerEnum innerEnum, IntrospectedTable introspectedTable) {
        if (this.suppressAllComments) {
            return;
        }

        StringBuilder sb = new StringBuilder();

        innerEnum.addJavaDocLine("/**");
        innerEnum.addJavaDocLine(" * This enum was generated by MyBatis Generator.");


        sb.append(" * This enum corresponds to the database table ");
        sb.append(introspectedTable.getFullyQualifiedTable());
        innerEnum.addJavaDocLine(sb.toString());

        addJavadocTag(innerEnum, false);

        innerEnum.addJavaDocLine(" */");
    }


    public void addFieldComment(Field field, IntrospectedTable introspectedTable, IntrospectedColumn introspectedColumn) {
        if (this.suppressAllComments) {
            return;
        }

        StringBuilder sb = new StringBuilder();

        field.addJavaDocLine("/**");
        field.addJavaDocLine(" * This field was generated by MyBatis Generator.");


        sb.append(" * This field corresponds to the database column ");
        sb.append(introspectedTable.getFullyQualifiedTable());
        sb.append('.');
        sb.append(introspectedColumn.getActualColumnName());
        field.addJavaDocLine(sb.toString());

        addJavadocTag(field, false);
        field.addJavaDocLine(" * " + introspectedColumn.getRemarks() );
        field.addJavaDocLine(" */");
    }

    public void addFieldComment(Field field, IntrospectedTable introspectedTable) {
        if (this.suppressAllComments) {
            return;
        }

        StringBuilder sb = new StringBuilder();

        field.addJavaDocLine("/**");
        field.addJavaDocLine(" * This field was generated by MyBatis Generator.");


        sb.append(" * This field corresponds to the database table ");
        sb.append(introspectedTable.getFullyQualifiedTable());
        field.addJavaDocLine(sb.toString());

        addJavadocTag(field, false);

        field.addJavaDocLine(" */");
    }

    public void addGeneralMethodComment(Method method, IntrospectedTable introspectedTable) {
        if (this.suppressAllComments) {
            return;
        }

        StringBuilder sb = new StringBuilder();

        method.addJavaDocLine("/**");
        method.addJavaDocLine(" * This method was generated by MyBatis Generator.");


        sb.append(" * This method corresponds to the database table ");
        sb.append(introspectedTable.getFullyQualifiedTable());
        method.addJavaDocLine(sb.toString());

        addJavadocTag(method, false);

        method.addJavaDocLine(" */");
    }


    public void addGetterComment(Method method, IntrospectedTable introspectedTable, IntrospectedColumn introspectedColumn) {
        if (this.suppressAllComments) {
            return;
        }

        StringBuilder sb = new StringBuilder();

        method.addJavaDocLine("/**");
        method.addJavaDocLine(" * This method was generated by MyBatis Generator.");


        sb.append(" * This method returns the value of the database column ");
        sb.append(introspectedTable.getFullyQualifiedTable());
        sb.append('.');
        sb.append(introspectedColumn.getActualColumnName());
        method.addJavaDocLine(sb.toString());

        method.addJavaDocLine(" *");

        sb.setLength(0);
        sb.append(" * @return the value of ");
        sb.append(introspectedTable.getFullyQualifiedTable());
        sb.append('.');
        sb.append(introspectedColumn.getActualColumnName());
        method.addJavaDocLine(sb.toString());

        addJavadocTag(method, false);

        method.addJavaDocLine(" */");
    }


    public void addSetterComment(Method method, IntrospectedTable introspectedTable, IntrospectedColumn introspectedColumn) {
        if (this.suppressAllComments) {
            return;
        }

        StringBuilder sb = new StringBuilder();

        method.addJavaDocLine("/**");
        method.addJavaDocLine(" * This method was generated by MyBatis Generator.");


        sb.append(" * This method sets the value of the database column ");
        sb.append(introspectedTable.getFullyQualifiedTable());
        sb.append('.');
        sb.append(introspectedColumn.getActualColumnName());
        method.addJavaDocLine(sb.toString());

        method.addJavaDocLine(" *");

        Parameter parm = (Parameter) method.getParameters().get(0);
        sb.setLength(0);
        sb.append(" * @param ");
        sb.append(parm.getName());
        sb.append(" the value for ");
        sb.append(introspectedTable.getFullyQualifiedTable());
        sb.append('.');
        sb.append(introspectedColumn.getActualColumnName());
        method.addJavaDocLine(sb.toString());

        addJavadocTag(method, false);

        method.addJavaDocLine(" */");
    }

    public void addClassComment(InnerClass innerClass, IntrospectedTable introspectedTable, boolean markAsDoNotDelete) {
        if (this.suppressAllComments) {
            return;
        }

        StringBuilder sb = new StringBuilder();

        innerClass.addJavaDocLine("/**");
        innerClass.addJavaDocLine(" * This class was generated by MyBatis Generator.");


        sb.append(" * This class corresponds to the database table ");
        sb.append(introspectedTable.getFullyQualifiedTable());
        innerClass.addJavaDocLine(sb.toString());

        addJavadocTag(innerClass, markAsDoNotDelete);

        innerClass.addJavaDocLine(" */");
    }
}