

# ApplySoftwareUpdateRequest

Request for ApplySoftwareUpdate.

## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**applyAll** | **Boolean** | Whether to apply the update to all nodes. If set to true, will explicitly restrict users from specifying any nodes, and apply software update to all nodes (where applicable) within the instance. |  [optional] |
|**nodeIds** | **List&lt;String&gt;** | Nodes to which we should apply the update to. Note all the selected nodes are updated in parallel. |  [optional] |



