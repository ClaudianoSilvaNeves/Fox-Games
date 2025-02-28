package com.eu.foxgames.twitch.model

/**
 * Class responsible for constructing a query for the Twitch API.
 *
 * This class allows for the dynamic creation of a query string, configuring parameters such as
 * search, fields, exclusions, limits, sorting, and filters.
 *
 * @property search The search term to be used in the query.
 * @property fields The fields to be returned in the query results.
 * @property exclude The fields to be excluded from the query results.
 * @property limit The maximum number of items to return in the query.
 * @property offset The offset for pagination in the query.
 * @property sort The sorting criteria for the query based on the field and order.
 * @property where Additional conditions to filter the query results.
 */
class Query {
    private var search: String = ""
    private var fields: String = ""
    private var exclude: String = ""
    private var limit: String = ""
    private var offset: String = ""
    private var sort: String = ""
    private var where: String = ""

    /**
     * Sets the search term for the query.
     *
     * @param search The search term to be used.
     * @return The current instance of [Query] for method chaining.
     */
    fun search(search: String): Query {
        this.search = "search \"$search\";"
        return this
    }

    /**
     * Sets the fields to be included in the query results.
     *
     * @param field The fields to be included in the query.
     * @return The current instance of [Query] for method chaining.
     */
    fun fields(field: String): Query {
        this.fields = "f $field;"
        return this
    }

    /**
     * Sets the fields to be excluded from the query results.
     *
     * @param field The fields to be excluded from the query.
     * @return The current instance of [Query] for method chaining.
     */
    fun exclude(field: String): Query {
        this.exclude = "x $field;"
        return this
    }

    /**
     * Sets the limit for the number of items to be returned by the query.
     *
     * @param limit The maximum number of items to be returned.
     * @return The current instance of [Query] for method chaining.
     */
    fun limit(limit: Int): Query {
        this.limit = "l $limit;"
        return this
    }

    /**
     * Sets the offset for the query, useful for pagination.
     *
     * @param offset The number of items to skip in the query.
     * @return The current instance of [Query] for method chaining.
     */
    fun offset(offset: Int): Query {
        this.offset = "o $offset;"
        return this
    }

    /**
     * Sets the sorting criteria for the query based on a field and order.
     *
     * @param field The field by which the results will be sorted.
     * @param order The order in which the results will be sorted (ascending or descending).
     * @return The current instance of [Query] for method chaining.
     */
    fun sort(field: String, order: Sort): Query {
        this.sort = "s $field ${order.apiName};"
        return this
    }

    /**
     * Sets additional conditions to filter the query results.
     *
     * @param where The condition to be applied in the query.
     * @return The current instance of [Query] for method chaining.
     */
    fun where(where: String): Query {
        if(where.contains("where ") || where.contains("w ")) {
            this.where = where
        } else {
            if(where.contains(";")) {
                this.where = "w id = $where"
            } else {
                this.where = "w id = $where;"
            }
        }
        return this
    }

    /**
     * Builds and returns the query string based on the configured parameters.
     *
     * @return The resulting query string with all configured parameters.
     */
    fun queryBuilder(): String {
        var query = ""
        if(search.isNotBlank()) {
            query += search
        }
        if(fields.isNotBlank()) {
            query += fields
        }
        if(exclude.isNotBlank()) {
            query += exclude
        }
        if(limit.isNotBlank()) {
            query += limit
        }
        if(offset.isNotBlank()) {
            query += offset
        }
        if(sort.isNotBlank()) {
            query += sort
        }
        if(where.isNotBlank()) {
            query += where
        }
        return query
    }
}