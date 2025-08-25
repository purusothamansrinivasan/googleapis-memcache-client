/**
 * MCP Server function for Performs the apply phase of the RescheduleMaintenance verb.
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

class Post_V1Beta2_Instance_Reschedule_MaintenanceMCPTool {
    
    public static Function<MCPServer.MCPRequest, MCPServer.MCPToolResult> getPost_V1Beta2_Instance_Reschedule_MaintenanceHandler(MCPServer.APIConfig config) {
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
        if (args.containsKey("instance")) {
            queryParams.add("instance=" + args.get("instance"));
        }
        if (args.containsKey("rescheduleType")) {
            queryParams.add("rescheduleType=" + args.get("rescheduleType"));
        }
        if (args.containsKey("scheduleTime")) {
            queryParams.add("scheduleTime=" + args.get("scheduleTime"));
        }
        if (args.containsKey("prettyPrint")) {
            queryParams.add("prettyPrint=" + args.get("prettyPrint"));
        }
                
                String queryString = queryParams.isEmpty() ? "" : "?" + String.join("&", queryParams);
                String url = config.getBaseUrl() + "/api/v2/post_v1beta2_instance_reschedule_maintenance" + queryString;
                
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
    
    public static MCPServer.Tool createPost_V1Beta2_Instance_Reschedule_MaintenanceTool(MCPServer.APIConfig config) {
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
        Map<String, Object> instanceProperty = new HashMap<>();
        instanceProperty.put("type", "string");
        instanceProperty.put("required", true);
        instanceProperty.put("description", "Required. Memcache instance resource name using the form: `projects/{project_id}/locations/{location_id}/instances/{instance_id}` where `location_id` refers to a GCP region.");
        properties.put("instance", instanceProperty);
        Map<String, Object> rescheduleTypeProperty = new HashMap<>();
        rescheduleTypeProperty.put("type", "string");
        rescheduleTypeProperty.put("required", false);
        rescheduleTypeProperty.put("description", "Input parameter: Required. If reschedule type is SPECIFIC_TIME, must set up schedule_time as well.");
        properties.put("rescheduleType", rescheduleTypeProperty);
        Map<String, Object> scheduleTimeProperty = new HashMap<>();
        scheduleTimeProperty.put("type", "string");
        scheduleTimeProperty.put("required", false);
        scheduleTimeProperty.put("description", "Input parameter: Timestamp when the maintenance shall be rescheduled to if reschedule_type=SPECIFIC_TIME, in RFC 3339 format, for example `2012-11-15T16:19:00.094Z`.");
        properties.put("scheduleTime", scheduleTimeProperty);
        Map<String, Object> prettyPrintProperty = new HashMap<>();
        prettyPrintProperty.put("type", "string");
        prettyPrintProperty.put("required", false);
        prettyPrintProperty.put("description", "Returns response with indentations and line breaks.");
        properties.put("prettyPrint", prettyPrintProperty);
        parameters.put("properties", properties);
        
        MCPServer.ToolDefinition definition = new MCPServer.ToolDefinition(
            "post_v1beta2_instance_reschedule_maintenance",
            "Performs the apply phase of the RescheduleMaintenance verb.",
            parameters
        );
        
        return new MCPServer.Tool(definition, getPost_V1Beta2_Instance_Reschedule_MaintenanceHandler(config));
    }
    
}