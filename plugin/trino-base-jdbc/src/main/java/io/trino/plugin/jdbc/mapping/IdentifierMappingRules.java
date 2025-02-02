/*
 * Copyright Starburst Data, Inc. All rights reserved.
 *
 * THIS IS UNPUBLISHED PROPRIETARY SOURCE CODE OF STARBURST DATA.
 * The copyright notice above does not evidence any
 * actual or intended publication of such source code.
 *
 * Redistribution of this material is strictly prohibited.
 */

package io.trino.plugin.jdbc.mapping;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

import static java.util.Objects.requireNonNull;

public class IdentifierMappingRules
{
    private final List<SchemaMappingRule> schemas;
    private final List<TableMappingRule> tables;

    @JsonCreator
    public IdentifierMappingRules(
            @JsonProperty("schemas") List<SchemaMappingRule> schemas,
            @JsonProperty("tables") List<TableMappingRule> tables)
    {
        this.schemas = requireNonNull(schemas, "schemaMappingRules is null");
        this.tables = requireNonNull(tables, "tableMappingRules is null");
    }

    @JsonProperty("schemas")
    public List<SchemaMappingRule> getSchemaMapping()
    {
        return schemas;
    }

    @JsonProperty("tables")
    public List<TableMappingRule> getTableMapping()
    {
        return tables;
    }
}
