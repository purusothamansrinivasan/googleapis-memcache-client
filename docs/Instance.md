

# Instance

A Memorystore for Memcached instance

## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**authorizedNetwork** | **String** | The full name of the Google Compute Engine [network](https://cloud.google.com/vpc/docs/vpc) to which the instance is connected. If left unspecified, the &#x60;default&#x60; network will be used. |  [optional] |
|**createTime** | **String** | Output only. The time the instance was created. |  [optional] [readonly] |
|**discoveryEndpoint** | **String** | Output only. Endpoint for the Discovery API. |  [optional] [readonly] |
|**displayName** | **String** | User provided name for the instance, which is only used for display purposes. Cannot be more than 80 characters. |  [optional] |
|**instanceMessages** | [**List&lt;InstanceMessage&gt;**](InstanceMessage.md) | List of messages that describe the current state of the Memcached instance. |  [optional] |
|**labels** | **Map&lt;String, String&gt;** | Resource labels to represent user-provided metadata. Refer to cloud documentation on labels for more details. https://cloud.google.com/compute/docs/labeling-resources |  [optional] |
|**maintenancePolicy** | [**GoogleCloudMemcacheV1beta2MaintenancePolicy**](GoogleCloudMemcacheV1beta2MaintenancePolicy.md) |  |  [optional] |
|**maintenanceSchedule** | [**MaintenanceSchedule**](MaintenanceSchedule.md) |  |  [optional] |
|**memcacheFullVersion** | **String** | Output only. The full version of memcached server running on this instance. System automatically determines the full memcached version for an instance based on the input MemcacheVersion. The full version format will be \&quot;memcached-1.5.16\&quot;. |  [optional] [readonly] |
|**memcacheNodes** | [**List&lt;Node&gt;**](Node.md) | Output only. List of Memcached nodes. Refer to Node message for more details. |  [optional] [readonly] |
|**memcacheVersion** | [**MemcacheVersionEnum**](#MemcacheVersionEnum) | The major version of Memcached software. If not provided, latest supported version will be used. Currently the latest supported major version is &#x60;MEMCACHE_1_5&#x60;. The minor version will be automatically determined by our system based on the latest supported minor version. |  [optional] |
|**name** | **String** | Required. Unique name of the resource in this scope including project and location using the form: &#x60;projects/{project_id}/locations/{location_id}/instances/{instance_id}&#x60; Note: Memcached instances are managed and addressed at the regional level so &#x60;location_id&#x60; here refers to a Google Cloud region; however, users may choose which zones Memcached nodes should be provisioned in within an instance. Refer to zones field for more details. |  [optional] |
|**nodeConfig** | [**NodeConfig**](NodeConfig.md) |  |  [optional] |
|**nodeCount** | **Integer** | Required. Number of nodes in the Memcached instance. |  [optional] |
|**parameters** | [**MemcacheParameters**](MemcacheParameters.md) |  |  [optional] |
|**reservedIpRangeId** | **List&lt;String&gt;** | Optional. Contains the id of allocated IP address ranges associated with the private service access connection for example, \&quot;test-default\&quot; associated with IP range 10.0.0.0/29. |  [optional] |
|**state** | [**StateEnum**](#StateEnum) | Output only. The state of this Memcached instance. |  [optional] [readonly] |
|**updateAvailable** | **Boolean** | Output only. Returns true if there is an update waiting to be applied |  [optional] [readonly] |
|**updateTime** | **String** | Output only. The time the instance was updated. |  [optional] [readonly] |
|**zones** | **List&lt;String&gt;** | Zones in which Memcached nodes should be provisioned. Memcached nodes will be equally distributed across these zones. If not provided, the service will by default create nodes in all zones in the region for the instance. |  [optional] |



## Enum: MemcacheVersionEnum

| Name | Value |
|---- | -----|
| MEMCACHE_VERSION_UNSPECIFIED | &quot;MEMCACHE_VERSION_UNSPECIFIED&quot; |
| MEMCACHE_1_5 | &quot;MEMCACHE_1_5&quot; |
| MEMCACHE_1_6_15 | &quot;MEMCACHE_1_6_15&quot; |



## Enum: StateEnum

| Name | Value |
|---- | -----|
| STATE_UNSPECIFIED | &quot;STATE_UNSPECIFIED&quot; |
| CREATING | &quot;CREATING&quot; |
| READY | &quot;READY&quot; |
| UPDATING | &quot;UPDATING&quot; |
| DELETING | &quot;DELETING&quot; |
| PERFORMING_MAINTENANCE | &quot;PERFORMING_MAINTENANCE&quot; |
| MEMCACHE_VERSION_UPGRADING | &quot;MEMCACHE_VERSION_UPGRADING&quot; |



