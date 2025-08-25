

# RescheduleMaintenanceRequest

Request for RescheduleMaintenance.

## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**rescheduleType** | [**RescheduleTypeEnum**](#RescheduleTypeEnum) | Required. If reschedule type is SPECIFIC_TIME, must set up schedule_time as well. |  [optional] |
|**scheduleTime** | **String** | Timestamp when the maintenance shall be rescheduled to if reschedule_type&#x3D;SPECIFIC_TIME, in RFC 3339 format, for example &#x60;2012-11-15T16:19:00.094Z&#x60;. |  [optional] |



## Enum: RescheduleTypeEnum

| Name | Value |
|---- | -----|
| RESCHEDULE_TYPE_UNSPECIFIED | &quot;RESCHEDULE_TYPE_UNSPECIFIED&quot; |
| IMMEDIATE | &quot;IMMEDIATE&quot; |
| NEXT_AVAILABLE_WINDOW | &quot;NEXT_AVAILABLE_WINDOW&quot; |
| SPECIFIC_TIME | &quot;SPECIFIC_TIME&quot; |



