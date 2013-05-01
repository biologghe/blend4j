package com.github.jmchilton.blend4j.galaxy.beans;

import org.apache.commons.lang.StringUtils;
import org.codehaus.jackson.annotate.JsonAnySetter;
import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.annotate.JsonProperty;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class Dataset extends HistoryDetails implements HasGalaxyUrl {
    private String dataType;
    private boolean deleted;
    private boolean purged;
    private boolean accessible;
    private String downloadUrl;
    private Integer fileSize;
    private String genomeBuild;
    private String dbKey;
    private boolean visible;
    private String galaxyUrl;
    private String miscInfo;
    private Map<String, Object> metaData = new HashMap<String, Object>();

    private static final String DELIMITER = ", ";
    public static final String METADATA_PREFIX = "metadata_";

    
    public boolean getDeleted() {
        return deleted;
    }
    
    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }
    
    public boolean getVisible() {
        return visible;
    }
    
    public void setVisible(boolean visible) {
        this.visible = visible;
    }

    public String getDataType() {
        return dataType;
    }
    
    @JsonProperty("data_type")
    public void setDataType(String dataType) {
        this.dataType = dataType;
    }

    public String getDownloadUrl() {
        return downloadUrl;
    }
    
    @JsonProperty("download_url")
    public void setDownloadUrl(String downloadUrl) {
        this.downloadUrl = downloadUrl;
    }
    
    @JsonIgnore
    public String getFullDownloadUrl() {
      return getGalaxyUrl() + getDownloadUrl();
    }

    public String getGenomeBuild() {
        return genomeBuild;
    }
    
    @JsonProperty("genome_build")
    public void setGenomeBuild(String genomeBuild) {
        this.genomeBuild = genomeBuild;
    }

    public Integer getFileSize() {
        return fileSize;
    }
    
    @JsonProperty("file_size")
    public void setFileSize(Integer fileSize) {
        this.fileSize = fileSize;
    }
    
    @JsonIgnore
    public void setGalaxyUrl(final String galaxyUrl) {
      this.galaxyUrl = galaxyUrl;
    }
    
    @JsonIgnore
    public String getGalaxyUrl() {
      return galaxyUrl;
    }

    public boolean isAccessible()
    {
        return accessible;
    }

    public void setAccessible(boolean accessible)
    {
        this.accessible = accessible;
    }

    public boolean isPurged()
    {
        return purged;
    }

    public void setPurged(boolean purged)
    {
        this.purged = purged;
    }

    public String getDbKey()
    {
        return dbKey;
    }

    @JsonProperty("metadata_dbkey")
    public void setDbKey(String dbKey)
    {
        this.dbKey = dbKey;
    }

    public Map<String, Object> getMetaData()
    {
        return metaData;
    }

    @JsonProperty("misc_info")
    public void setMiscInfo(String miscInfo)
    {
        this.miscInfo = miscInfo;
    }

    public String getMiscInfo()
    {
        return miscInfo;
    }

    @JsonAnySetter
    public void add(String key, Object value)
    {
        if (StringUtils.startsWith(key, METADATA_PREFIX))
        {
            key = StringUtils.removeStart(key, METADATA_PREFIX);
            if ("column_names".equals(key))
            {
                value = createListfromString((String) value);
            }
            else if("column_types".equals(key))
            {
                value = createListOfColumnTypes(createListfromString((String) value));
            }
            metaData.put(key, value);
        }

    }

    private List<ColumnType> createListOfColumnTypes(List<String> galaxyColumnTypes)
    {
        List<ColumnType> columnTypes = new ArrayList<ColumnType>();
        for (String galaxyColumnType : galaxyColumnTypes)
        {
            ColumnType type = ColumnType.valueOf(galaxyColumnType.toUpperCase());
            System.out.println(type);
        }
        return columnTypes;
    }

    private List<String> createListfromString(String string)
    {
        if (StringUtils.isEmpty(string))
        {
            return Collections.emptyList();
        }
        return Arrays.asList(StringUtils.split(string, DELIMITER));
    }
}
