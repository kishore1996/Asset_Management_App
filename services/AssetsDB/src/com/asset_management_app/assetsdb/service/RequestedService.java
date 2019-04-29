/*Copyright (c) 2019-2020 imaginea.com All Rights Reserved.
 This software is the confidential and proprietary information of imaginea.com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with imaginea.com*/
package com.asset_management_app.assetsdb.service;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/

import java.io.OutputStream;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.wavemaker.runtime.data.exception.EntityNotFoundException;
import com.wavemaker.runtime.data.export.DataExportOptions;
import com.wavemaker.runtime.data.export.ExportType;
import com.wavemaker.runtime.data.expression.QueryFilter;
import com.wavemaker.runtime.data.model.AggregationInfo;
import com.wavemaker.runtime.file.model.Downloadable;

import com.asset_management_app.assetsdb.Requested;

/**
 * Service object for domain model class {@link Requested}.
 */
public interface RequestedService {

    /**
     * Creates a new Requested. It does cascade insert for all the children in a single transaction.
     *
     * This method overrides the input field values using Server side or database managed properties defined on Requested if any.
     *
     * @param requested Details of the Requested to be created; value cannot be null.
     * @return The newly created Requested.
     */
    Requested create(@Valid Requested requested);


	/**
     * Returns Requested by given id if exists.
     *
     * @param requestedId The id of the Requested to get; value cannot be null.
     * @return Requested associated with the given requestedId.
	 * @throws EntityNotFoundException If no Requested is found.
     */
    Requested getById(Integer requestedId);

    /**
     * Find and return the Requested by given id if exists, returns null otherwise.
     *
     * @param requestedId The id of the Requested to get; value cannot be null.
     * @return Requested associated with the given requestedId.
     */
    Requested findById(Integer requestedId);

	/**
     * Find and return the list of Requesteds by given id's.
     *
     * If orderedReturn true, the return List is ordered and positional relative to the incoming ids.
     *
     * In case of unknown entities:
     *
     * If enabled, A null is inserted into the List at the proper position(s).
     * If disabled, the nulls are not put into the return List.
     *
     * @param requestedIds The id's of the Requested to get; value cannot be null.
     * @param orderedReturn Should the return List be ordered and positional in relation to the incoming ids?
     * @return Requesteds associated with the given requestedIds.
     */
    List<Requested> findByMultipleIds(List<Integer> requestedIds, boolean orderedReturn);


    /**
     * Updates the details of an existing Requested. It replaces all fields of the existing Requested with the given requested.
     *
     * This method overrides the input field values using Server side or database managed properties defined on Requested if any.
     *
     * @param requested The details of the Requested to be updated; value cannot be null.
     * @return The updated Requested.
     * @throws EntityNotFoundException if no Requested is found with given input.
     */
    Requested update(@Valid Requested requested);


    /**
     * Partially updates the details of an existing Requested. It updates only the
     * fields of the existing Requested which are passed in the requestedPatch.
     *
     * This method overrides the input field values using Server side or database managed properties defined on Requested if any.
     *
     * @param requestedId The id of the Requested to be deleted; value cannot be null.
     * @param requestedPatch The partial data of Requested which is supposed to be updated; value cannot be null.
     * @return The updated Requested.
     * @throws EntityNotFoundException if no Requested is found with given input.
     */
    Requested partialUpdate(Integer requestedId, Map<String, Object> requestedPatch);

    /**
     * Deletes an existing Requested with the given id.
     *
     * @param requestedId The id of the Requested to be deleted; value cannot be null.
     * @return The deleted Requested.
     * @throws EntityNotFoundException if no Requested found with the given id.
     */
    Requested delete(Integer requestedId);

    /**
     * Deletes an existing Requested with the given object.
     *
     * @param requested The instance of the Requested to be deleted; value cannot be null.
     */
    void delete(Requested requested);

    /**
     * Find all Requesteds matching the given QueryFilter(s).
     * All the QueryFilter(s) are ANDed to filter the results.
     * This method returns Paginated results.
     *
     * @deprecated Use {@link #findAll(String, Pageable)} instead.
     *
     * @param queryFilters Array of queryFilters to filter the results; No filters applied if the input is null/empty.
     * @param pageable Details of the pagination information along with the sorting options. If null returns all matching records.
     * @return Paginated list of matching Requesteds.
     *
     * @see QueryFilter
     * @see Pageable
     * @see Page
     */
    @Deprecated
    Page<Requested> findAll(QueryFilter[] queryFilters, Pageable pageable);

    /**
     * Find all Requesteds matching the given input query. This method returns Paginated results.
     * Note: Go through the documentation for <u>query</u> syntax.
     *
     * @param query The query to filter the results; No filters applied if the input is null/empty.
     * @param pageable Details of the pagination information along with the sorting options. If null returns all matching records.
     * @return Paginated list of matching Requesteds.
     *
     * @see Pageable
     * @see Page
     */
    Page<Requested> findAll(String query, Pageable pageable);

    /**
     * Exports all Requesteds matching the given input query to the given exportType format.
     * Note: Go through the documentation for <u>query</u> syntax.
     *
     * @param exportType The format in which to export the data; value cannot be null.
     * @param query The query to filter the results; No filters applied if the input is null/empty.
     * @param pageable Details of the pagination information along with the sorting options. If null exports all matching records.
     * @return The Downloadable file in given export type.
     *
     * @see Pageable
     * @see ExportType
     * @see Downloadable
     */
    Downloadable export(ExportType exportType, String query, Pageable pageable);

    /**
     * Exports all Requesteds matching the given input query to the given exportType format.
     *
     * @param options The export options provided by the user; No filters applied if the input is null/empty.
     * @param pageable Details of the pagination information along with the sorting options. If null exports all matching records.
     * @param outputStream The output stream of the file for the exported data to be written to.
     *
     * @see DataExportOptions
     * @see Pageable
     * @see OutputStream
     */
    void export(DataExportOptions options, Pageable pageable, OutputStream outputStream);

    /**
     * Retrieve the count of the Requesteds in the repository with matching query.
     * Note: Go through the documentation for <u>query</u> syntax.
     *
     * @param query query to filter results. No filters applied if the input is null/empty.
     * @return The count of the Requested.
     */
    long count(String query);

    /**
     * Retrieve aggregated values with matching aggregation info.
     *
     * @param aggregationInfo info related to aggregations.
     * @param pageable Details of the pagination information along with the sorting options. If null exports all matching records.
     * @return Paginated data with included fields.
     *
     * @see AggregationInfo
     * @see Pageable
     * @see Page
	 */
    Page<Map<String, Object>> getAggregatedValues(AggregationInfo aggregationInfo, Pageable pageable);


}