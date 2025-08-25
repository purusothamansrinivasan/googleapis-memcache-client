

# ListInstancesResponse

Response for ListInstances.

## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**nextPageToken** | **String** | Token to retrieve the next page of results, or empty if there are no more results in the list. |  [optional] |
|**resources** | [**List&lt;Instance&gt;**](Instance.md) | A list of Memcached instances in the project in the specified location, or across all locations. If the &#x60;location_id&#x60; in the parent field of the request is \&quot;-\&quot;, all regions available to the project are queried, and the results aggregated. |  [optional] |
|**unreachable** | **List&lt;String&gt;** | Locations that could not be reached. |  [optional] |



