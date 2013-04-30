package com.github.jmchilton.blend4j.galaxy.beans;

import java.util.List;


/**
 * Created with IntelliJ IDEA.
 * User: mlogghe
 * Date: 4/26/13
 * Time: 1:49 PM
 * To change this template use File | Settings | File Templates.
 */
public enum ColumnType
{
    STR("str", String.class), FLOAT("float", Double.class), INT("int", Integer.class), LIST("list", List.class);
    private String galaxyColumnType;
    private Class clazz;

    ColumnType(String galaxyColumnType, Class clazz)
    {
        this.galaxyColumnType = galaxyColumnType;
        this.clazz = clazz;
    }

    public Class getType()
    {
        return clazz;
    }

    @Override
    public String toString()
    {
        return galaxyColumnType;
    }

    public static void main(String[] args)
    {
        System.out.println(ColumnType.valueOf("INT"));
    }
}

