

# GoogleCloudMemcacheV1beta2MaintenancePolicy

Maintenance policy per instance.

## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**createTime** | **String** | Output only. The time when the policy was created. |  [optional] [readonly] |
|**description** | **String** | Description of what this policy is for. Create/Update methods return INVALID_ARGUMENT if the length is greater than 512. |  [optional] |
|**updateTime** | **String** | Output only. The time when the policy was updated. |  [optional] [readonly] |
|**weeklyMaintenanceWindow** | [**List&lt;WeeklyMaintenanceWindow&gt;**](WeeklyMaintenanceWindow.md) | Required. Maintenance window that is applied to resources covered by this policy. Minimum 1. For the current version, the maximum number of weekly_maintenance_windows is expected to be one. |  [optional] |



