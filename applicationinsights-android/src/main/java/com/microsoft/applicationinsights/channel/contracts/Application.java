package com.microsoft.applicationinsights.channel.contracts;
import java.io.IOException;
import java.io.Writer;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.ArrayList;
import com.microsoft.applicationinsights.channel.contracts.shared.ITelemetry;
import com.microsoft.applicationinsights.channel.contracts.shared.ITelemetryData;
import com.microsoft.applicationinsights.channel.contracts.shared.IContext;
import com.microsoft.applicationinsights.channel.contracts.shared.IJsonSerializable;
import com.microsoft.applicationinsights.channel.contracts.shared.JsonHelper;

/**
 * Data contract class Application.
 */
public class Application implements
    IJsonSerializable
{
    /**
     * The ID of this application
     */
    private String id;

    /**
     * Backing field for property Ver.
     */
    private String ver;
    
    /**
     * Initializes a new instance of the <see cref="Application"/> class.
     */
    public Application()
    {
        this.InitializeFields();
    }
    
    /**
     * Gets the Ver property.
     */
    public String getVer() {
        return this.ver;
    }
    
    /**
     * Sets the Ver property.
     */
    public void setVer(String value) {
        this.ver = value;
    }

    /**
     * Gets the Id property.
     */
    public String getId() {
        return id;
    }

    /**
     * Sets the Id property.
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * Adds all members of this class to a hashmap
     * @param map to which the members of this class will be added.
     */
    public void addToHashMap(LinkedHashMap<String, String> map)
    {
        if (!(this.ver == null)) {
            map.put("ai.application.ver", this.ver);
            map.put("ai.application.id", this.id);
        }
    }
    

    /**
     * Serializes the beginning of this object to the passed in writer.
     * @param writer The writer to serialize this object to.
     */
    @Override
    public void serialize(Writer writer) throws IOException
    {
        if (writer == null)
        {
            throw new IllegalArgumentException("writer");
        }
        
        writer.write('{');
        this.serializeContent(writer);
        writer.write('}');
    }

    /**
     * Serializes the beginning of this object to the passed in writer.
     * @param writer The writer to serialize this object to.
     */
    protected String serializeContent(Writer writer) throws IOException
    {
        String prefix = "";
        if (!(this.ver == null))
        {
            writer.write(prefix + "\"ai.application.ver\":");
            writer.write(JsonHelper.convert(this.ver));
            prefix = ",";
        }
        
        return prefix;
    }
    
    /**
     * Optionally initializes fields for the current context.
     */
    protected void InitializeFields() {
        
    }
}
