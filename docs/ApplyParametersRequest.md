

# ApplyParametersRequest

Request for ApplyParameters.

## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**applyAll** | **Boolean** | Whether to apply instance-level parameter group to all nodes. If set to true, users are restricted from specifying individual nodes, and &#x60;ApplyParameters&#x60; updates all nodes within the instance. |  [optional] |
|**nodeIds** | **List&lt;String&gt;** | Nodes to which the instance-level parameter group is applied. |  [optional] |



