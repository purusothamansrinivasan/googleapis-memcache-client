

# GoogleCloudSaasacceleratorManagementProvidersV1SloMetadata

SloMetadata contains resources required for proper SLO classification of the instance.

## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**nodes** | [**List&lt;GoogleCloudSaasacceleratorManagementProvidersV1NodeSloMetadata&gt;**](GoogleCloudSaasacceleratorManagementProvidersV1NodeSloMetadata.md) | Optional. List of nodes. Some producers need to use per-node metadata to calculate SLO. This field allows such producers to publish per-node SLO meta data, which will be consumed by SSA Eligibility Exporter and published in the form of per node metric to Monarch. |  [optional] |
|**perSliEligibility** | [**GoogleCloudSaasacceleratorManagementProvidersV1PerSliSloEligibility**](GoogleCloudSaasacceleratorManagementProvidersV1PerSliSloEligibility.md) |  |  [optional] |
|**tier** | **String** | Name of the SLO tier the Instance belongs to. This name will be expected to match the tiers specified in the service SLO configuration. Field is mandatory and must not be empty. |  [optional] |



