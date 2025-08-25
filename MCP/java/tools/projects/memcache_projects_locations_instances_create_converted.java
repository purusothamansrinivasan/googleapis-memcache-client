/**
 * MCP Server function for Creates a new Instance in a given location.
 */

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.*;
import java.util.function.Function;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.JsonNode;

class Post_V1Beta2_Parent_InstancesMCPTool {
    
    public static Function<MCPServer.MCPRequest, MCPServer.MCPToolResult> getPost_V1Beta2_Parent_InstancesHandler(MCPServer.APIConfig config) {
        return (request) -> {
            try {
                Map<String, Object> args = request.getArguments();
                if (args == null) {
                    return new MCPServer.MCPToolResult("Invalid arguments object", true);
                }
                
                List<String> queryParams = new ArrayList<>();
        if (args.containsKey("$.xgafv")) {
            queryParams.add("$.xgafv=" + args.get("$.xgafv"));
        }
        if (args.containsKey("access_token")) {
            queryParams.add("access_token=" + args.get("access_token"));
        }
        if (args.containsKey("alt")) {
            queryParams.add("alt=" + args.get("alt"));
        }
        if (args.containsKey("callback")) {
            queryParams.add("callback=" + args.get("callback"));
        }
        if (args.containsKey("fields")) {
            queryParams.add("fields=" + args.get("fields"));
        }
        if (args.containsKey("key")) {
            queryParams.add("key=" + args.get("key"));
        }
        if (args.containsKey("oauth_token")) {
            queryParams.add("oauth_token=" + args.get("oauth_token"));
        }
        if (args.containsKey("quotaUser")) {
            queryParams.add("quotaUser=" + args.get("quotaUser"));
        }
        if (args.containsKey("upload_protocol")) {
            queryParams.add("upload_protocol=" + args.get("upload_protocol"));
        }
        if (args.containsKey("uploadType")) {
            queryParams.add("uploadType=" + args.get("uploadType"));
        }
        if (args.containsKey("parent")) {
            queryParams.add("parent=" + args.get("parent"));
        }
        if (args.containsKey("instanceId")) {
            queryParams.add("instanceId=" + args.get("instanceId"));
        }
        if (args.containsKey("state")) {
            queryParams.add("state=" + args.get("state"));
        }
        if (args.containsKey("createTime")) {
            queryParams.add("createTime=" + args.get("createTime"));
        }
        if (args.containsKey("updateTime")) {
            queryParams.add("updateTime=" + args.get("updateTime"));
        }
        if (args.containsKey("authorizedNetwork")) {
            queryParams.add("authorizedNetwork=" + args.get("authorizedNetwork"));
        }
        if (args.containsKey("memcacheVersion")) {
            queryParams.add("memcacheVersion=" + args.get("memcacheVersion"));
        }
        if (args.containsKey("displayName")) {
            queryParams.add("displayName=" + args.get("displayName"));
        }
        if (args.containsKey("discoveryEndpoint")) {
            queryParams.add("discoveryEndpoint=" + args.get("discoveryEndpoint"));
        }
        if (args.containsKey("name")) {
            queryParams.add("name=" + args.get("name"));
        }
        if (args.containsKey("memcacheFullVersion")) {
            queryParams.add("memcacheFullVersion=" + args.get("memcacheFullVersion"));
        }
        if (args.containsKey("nodeCount")) {
            queryParams.add("nodeCount=" + args.get("nodeCount"));
        }
        if (args.containsKey("prettyPrint")) {
            queryParams.add("prettyPrint=" + args.get("prettyPrint"));
        }
        if (args.containsKey("updateAvailable")) {
            queryParams.add("updateAvailable=" + args.get("updateAvailable"));
        }
        if (args.containsKey("maintenanceSchedule")) {
            queryParams.add("maintenanceSchedule=" + args.get("maintenanceSchedule"));
        }
        if (args.containsKey("labels")) {
            queryParams.add("labels=" + args.get("labels"));
        }
        if (args.containsKey("maintenancePolicy")) {
            queryParams.add("maintenancePolicy=" + args.get("maintenancePolicy"));
        }
        if (args.containsKey("parameters")) {
            queryParams.add("parameters=" + args.get("parameters"));
        }
        if (args.containsKey("nodeConfig")) {
            queryParams.add("nodeConfig=" + args.get("nodeConfig"));
        }
        if (args.containsKey("reservedIpRangeId")) {
            queryParams.add("reservedIpRangeId=" + args.get("reservedIpRangeId"));
        }
        if (args.containsKey("memcacheNodes")) {
            queryParams.add("memcacheNodes=" + args.get("memcacheNodes"));
        }
        if (args.containsKey("zones")) {
            queryParams.add("zones=" + args.get("zones"));
        }
        if (args.containsKey("instanceMessages")) {
            queryParams.add("instanceMessages=" + args.get("instanceMessages"));
        }
                
                String queryString = queryParams.isEmpty() ? "" : "?" + String.join("&", queryParams);
                String url = config.getBaseUrl() + "/api/v2/post_v1beta2_parent_instances" + queryString;
                
                HttpClient client = HttpClient.newHttpClient();
                HttpRequest httpRequest = HttpRequest.newBuilder()
                    .uri(URI.create(url))
                    .header("Authorization", "Bearer " + config.getApiKey())
                    .header("Accept", "application/json")
                    .GET()
                    .build();
                
                HttpResponse<String> response = client.send(httpRequest, HttpResponse.BodyHandlers.ofString());
                
                if (response.statusCode() >= 400) {
                    return new MCPServer.MCPToolResult("API error: " + response.body(), true);
                }
                
                // Pretty print JSON
                ObjectMapper mapper = new ObjectMapper();
                JsonNode jsonNode = mapper.readTree(response.body());
                String prettyJson = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(jsonNode);
                
                return new MCPServer.MCPToolResult(prettyJson);
                
            } catch (IOException | InterruptedException e) {
                return new MCPServer.MCPToolResult("Request failed: " + e.getMessage(), true);
            } catch (Exception e) {
                return new MCPServer.MCPToolResult("Unexpected error: " + e.getMessage(), true);
            }
        };
    }
    
    public static MCPServer.Tool createPost_V1Beta2_Parent_InstancesTool(MCPServer.APIConfig config) {
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("type", "object");
        Map<String, Object> properties = new HashMap<>();
        Map<String, Object> $.xgafvProperty = new HashMap<>();
        $.xgafvProperty.put("type", "string");
        $.xgafvProperty.put("required", false);
        $.xgafvProperty.put("description", "V1 error format.");
        properties.put("$.xgafv", $.xgafvProperty);
        Map<String, Object> access_tokenProperty = new HashMap<>();
        access_tokenProperty.put("type", "string");
        access_tokenProperty.put("required", false);
        access_tokenProperty.put("description", "OAuth access token.");
        properties.put("access_token", access_tokenProperty);
        Map<String, Object> altProperty = new HashMap<>();
        altProperty.put("type", "string");
        altProperty.put("required", false);
        altProperty.put("description", "Data format for response.");
        properties.put("alt", altProperty);
        Map<String, Object> callbackProperty = new HashMap<>();
        callbackProperty.put("type", "string");
        callbackProperty.put("required", false);
        callbackProperty.put("description", "JSONP");
        properties.put("callback", callbackProperty);
        Map<String, Object> fieldsProperty = new HashMap<>();
        fieldsProperty.put("type", "string");
        fieldsProperty.put("required", false);
        fieldsProperty.put("description", "Selector specifying which fields to include in a partial response.");
        properties.put("fields", fieldsProperty);
        Map<String, Object> keyProperty = new HashMap<>();
        keyProperty.put("type", "string");
        keyProperty.put("required", false);
        keyProperty.put("description", "API key. Your API key identifies your project and provides you with API access, quota, and reports. Required unless you provide an OAuth 2.0 token.");
        properties.put("key", keyProperty);
        Map<String, Object> oauth_tokenProperty = new HashMap<>();
        oauth_tokenProperty.put("type", "string");
        oauth_tokenProperty.put("required", false);
        oauth_tokenProperty.put("description", "OAuth 2.0 token for the current user.");
        properties.put("oauth_token", oauth_tokenProperty);
        Map<String, Object> quotaUserProperty = new HashMap<>();
        quotaUserProperty.put("type", "string");
        quotaUserProperty.put("required", false);
        quotaUserProperty.put("description", "Available to use for quota purposes for server-side applications. Can be any arbitrary string assigned to a user, but should not exceed 40 characters.");
        properties.put("quotaUser", quotaUserProperty);
        Map<String, Object> upload_protocolProperty = new HashMap<>();
        upload_protocolProperty.put("type", "string");
        upload_protocolProperty.put("required", false);
        upload_protocolProperty.put("description", "Upload protocol for media (e.g. \"raw\", \"multipart\\");
        properties.put("upload_protocol", upload_protocolProperty);
        Map<String, Object> uploadTypeProperty = new HashMap<>();
        uploadTypeProperty.put("type", "string");
        uploadTypeProperty.put("required", false);
        uploadTypeProperty.put("description", "Legacy upload protocol for media (e.g. \"media\", \"multipart\\");
        properties.put("uploadType", uploadTypeProperty);
        Map<String, Object> parentProperty = new HashMap<>();
        parentProperty.put("type", "string");
        parentProperty.put("required", true);
        parentProperty.put("description", "Required. The resource name of the instance location using the form: `projects/{project_id}/locations/{location_id}` where `location_id` refers to a GCP region");
        properties.put("parent", parentProperty);
        Map<String, Object> instanceIdProperty = new HashMap<>();
        instanceIdProperty.put("type", "string");
        instanceIdProperty.put("required", false);
        instanceIdProperty.put("description", "Required. The logical name of the Memcached instance in the user project with the following restrictions: * Must contain only lowercase letters, numbers, and hyphens. * Must start with a letter. * Must be between 1-40 characters. * Must end with a number or a letter. * Must be unique within the user project / location. If any of the above are not met, the API raises an invalid argument error.");
        properties.put("instanceId", instanceIdProperty);
        Map<String, Object> stateProperty = new HashMap<>();
        stateProperty.put("type", "string");
        stateProperty.put("required", false);
        stateProperty.put("description", "Input parameter: Output only. The state of this Memcached instance.");
        properties.put("state", stateProperty);
        Map<String, Object> createTimeProperty = new HashMap<>();
        createTimeProperty.put("type", "string");
        createTimeProperty.put("required", false);
        createTimeProperty.put("description", "Input parameter: Output only. The time the instance was created.");
        properties.put("createTime", createTimeProperty);
        Map<String, Object> updateTimeProperty = new HashMap<>();
        updateTimeProperty.put("type", "string");
        updateTimeProperty.put("required", false);
        updateTimeProperty.put("description", "Input parameter: Output only. The time the instance was updated.");
        properties.put("updateTime", updateTimeProperty);
        Map<String, Object> authorizedNetworkProperty = new HashMap<>();
        authorizedNetworkProperty.put("type", "string");
        authorizedNetworkProperty.put("required", false);
        authorizedNetworkProperty.put("description", "Input parameter: The full name of the Google Compute Engine [network](https://cloud.google.com/vpc/docs/vpc) to which the instance is connected. If left unspecified, the `default` network will be used.");
        properties.put("authorizedNetwork", authorizedNetworkProperty);
        Map<String, Object> memcacheVersionProperty = new HashMap<>();
        memcacheVersionProperty.put("type", "string");
        memcacheVersionProperty.put("required", false);
        memcacheVersionProperty.put("description", "Input parameter: The major version of Memcached software. If not provided, latest supported version will be used. Currently the latest supported major version is `MEMCACHE_1_5`. The minor version will be automatically determined by our system based on the latest supported minor version.");
        properties.put("memcacheVersion", memcacheVersionProperty);
        Map<String, Object> displayNameProperty = new HashMap<>();
        displayNameProperty.put("type", "string");
        displayNameProperty.put("required", false);
        displayNameProperty.put("description", "Input parameter: User provided name for the instance, which is only used for display purposes. Cannot be more than 80 characters.");
        properties.put("displayName", displayNameProperty);
        Map<String, Object> discoveryEndpointProperty = new HashMap<>();
        discoveryEndpointProperty.put("type", "string");
        discoveryEndpointProperty.put("required", false);
        discoveryEndpointProperty.put("description", "Input parameter: Output only. Endpoint for the Discovery API.");
        properties.put("discoveryEndpoint", discoveryEndpointProperty);
        Map<String, Object> nameProperty = new HashMap<>();
        nameProperty.put("type", "string");
        nameProperty.put("required", false);
        nameProperty.put("description", "Input parameter: Required. Unique name of the resource in this scope including project and location using the form: `projects/{project_id}/locations/{location_id}/instances/{instance_id}` Note: Memcached instances are managed and addressed at the regional level so `location_id` here refers to a Google Cloud region; however, users may choose which zones Memcached nodes should be provisioned in within an instance. Refer to zones field for more details.");
        properties.put("name", nameProperty);
        Map<String, Object> memcacheFullVersionProperty = new HashMap<>();
        memcacheFullVersionProperty.put("type", "string");
        memcacheFullVersionProperty.put("required", false);
        memcacheFullVersionProperty.put("description", "Input parameter: Output only. The full version of memcached server running on this instance. System automatically determines the full memcached version for an instance based on the input MemcacheVersion. The full version format will be \"memcached-1.5.16\".");
        properties.put("memcacheFullVersion", memcacheFullVersionProperty);
        Map<String, Object> nodeCountProperty = new HashMap<>();
        nodeCountProperty.put("type", "string");
        nodeCountProperty.put("required", false);
        nodeCountProperty.put("description", "Input parameter: Required. Number of nodes in the Memcached instance.");
        properties.put("nodeCount", nodeCountProperty);
        Map<String, Object> prettyPrintProperty = new HashMap<>();
        prettyPrintProperty.put("type", "string");
        prettyPrintProperty.put("required", false);
        prettyPrintProperty.put("description", "Returns response with indentations and line breaks.");
        properties.put("prettyPrint", prettyPrintProperty);
        Map<String, Object> updateAvailableProperty = new HashMap<>();
        updateAvailableProperty.put("type", "string");
        updateAvailableProperty.put("required", false);
        updateAvailableProperty.put("description", "Input parameter: Output only. Returns true if there is an update waiting to be applied");
        properties.put("updateAvailable", updateAvailableProperty);
        Map<String, Object> maintenanceScheduleProperty = new HashMap<>();
        maintenanceScheduleProperty.put("type", "string");
        maintenanceScheduleProperty.put("required", false);
        maintenanceScheduleProperty.put("description", "Input parameter: Upcoming maintenance schedule.");
        properties.put("maintenanceSchedule", maintenanceScheduleProperty);
        Map<String, Object> labelsProperty = new HashMap<>();
        labelsProperty.put("type", "string");
        labelsProperty.put("required", false);
        labelsProperty.put("description", "Input parameter: Resource labels to represent user-provided metadata. Refer to cloud documentation on labels for more details. https://cloud.google.com/compute/docs/labeling-resources");
        properties.put("labels", labelsProperty);
        Map<String, Object> maintenancePolicyProperty = new HashMap<>();
        maintenancePolicyProperty.put("type", "string");
        maintenancePolicyProperty.put("required", false);
        maintenancePolicyProperty.put("description", "Input parameter: Maintenance policy per instance.");
        properties.put("maintenancePolicy", maintenancePolicyProperty);
        Map<String, Object> parametersProperty = new HashMap<>();
        parametersProperty.put("type", "string");
        parametersProperty.put("required", false);
        parametersProperty.put("description", "");
        properties.put("parameters", parametersProperty);
        Map<String, Object> nodeConfigProperty = new HashMap<>();
        nodeConfigProperty.put("type", "string");
        nodeConfigProperty.put("required", false);
        nodeConfigProperty.put("description", "Input parameter: Configuration for a Memcached Node.");
        properties.put("nodeConfig", nodeConfigProperty);
        Map<String, Object> reservedIpRangeIdProperty = new HashMap<>();
        reservedIpRangeIdProperty.put("type", "string");
        reservedIpRangeIdProperty.put("required", false);
        reservedIpRangeIdProperty.put("description", "Input parameter: Optional. Contains the id of allocated IP address ranges associated with the private service access connection for example, \"test-default\" associated with IP range 10.0.0.0/29.");
        properties.put("reservedIpRangeId", reservedIpRangeIdProperty);
        Map<String, Object> memcacheNodesProperty = new HashMap<>();
        memcacheNodesProperty.put("type", "string");
        memcacheNodesProperty.put("required", false);
        memcacheNodesProperty.put("description", "Input parameter: Output only. List of Memcached nodes. Refer to Node message for more details.");
        properties.put("memcacheNodes", memcacheNodesProperty);
        Map<String, Object> zonesProperty = new HashMap<>();
        zonesProperty.put("type", "string");
        zonesProperty.put("required", false);
        zonesProperty.put("description", "Input parameter: Zones in which Memcached nodes should be provisioned. Memcached nodes will be equally distributed across these zones. If not provided, the service will by default create nodes in all zones in the region for the instance.");
        properties.put("zones", zonesProperty);
        Map<String, Object> instanceMessagesProperty = new HashMap<>();
        instanceMessagesProperty.put("type", "string");
        instanceMessagesProperty.put("required", false);
        instanceMessagesProperty.put("description", "Input parameter: List of messages that describe the current state of the Memcached instance.");
        properties.put("instanceMessages", instanceMessagesProperty);
        parameters.put("properties", properties);
        
        MCPServer.ToolDefinition definition = new MCPServer.ToolDefinition(
            "post_v1beta2_parent_instances",
            "Creates a new Instance in a given location.",
            parameters
        );
        
        return new MCPServer.Tool(definition, getPost_V1Beta2_Parent_InstancesHandler(config));
    }
    
}