package tools

import (
	"context"
	"encoding/json"
	"fmt"
	"io"
	"net/http"
	"strings"
	"bytes"

	"github.com/cloud-memorystore-for-memcached-api/mcp-server/config"
	"github.com/cloud-memorystore-for-memcached-api/mcp-server/models"
	"github.com/mark3labs/mcp-go/mcp"
)

func Memcache_projects_locations_instances_createHandler(cfg *config.APIConfig) func(ctx context.Context, request mcp.CallToolRequest) (*mcp.CallToolResult, error) {
	return func(ctx context.Context, request mcp.CallToolRequest) (*mcp.CallToolResult, error) {
		args, ok := request.Params.Arguments.(map[string]any)
		if !ok {
			return mcp.NewToolResultError("Invalid arguments object"), nil
		}
		parentVal, ok := args["parent"]
		if !ok {
			return mcp.NewToolResultError("Missing required path parameter: parent"), nil
		}
		parent, ok := parentVal.(string)
		if !ok {
			return mcp.NewToolResultError("Invalid path parameter: parent"), nil
		}
		queryParams := make([]string, 0)
		if val, ok := args["$.xgafv"]; ok {
			queryParams = append(queryParams, fmt.Sprintf("$.xgafv=%v", val))
		}
		if val, ok := args["access_token"]; ok {
			queryParams = append(queryParams, fmt.Sprintf("access_token=%v", val))
		}
		if val, ok := args["alt"]; ok {
			queryParams = append(queryParams, fmt.Sprintf("alt=%v", val))
		}
		if val, ok := args["callback"]; ok {
			queryParams = append(queryParams, fmt.Sprintf("callback=%v", val))
		}
		if val, ok := args["fields"]; ok {
			queryParams = append(queryParams, fmt.Sprintf("fields=%v", val))
		}
		if val, ok := args["key"]; ok {
			queryParams = append(queryParams, fmt.Sprintf("key=%v", val))
		}
		if val, ok := args["oauth_token"]; ok {
			queryParams = append(queryParams, fmt.Sprintf("oauth_token=%v", val))
		}
		if val, ok := args["prettyPrint"]; ok {
			queryParams = append(queryParams, fmt.Sprintf("prettyPrint=%v", val))
		}
		if val, ok := args["quotaUser"]; ok {
			queryParams = append(queryParams, fmt.Sprintf("quotaUser=%v", val))
		}
		if val, ok := args["upload_protocol"]; ok {
			queryParams = append(queryParams, fmt.Sprintf("upload_protocol=%v", val))
		}
		if val, ok := args["uploadType"]; ok {
			queryParams = append(queryParams, fmt.Sprintf("uploadType=%v", val))
		}
		if val, ok := args["instanceId"]; ok {
			queryParams = append(queryParams, fmt.Sprintf("instanceId=%v", val))
		}
		// Handle multiple authentication parameters
		if cfg.BearerToken != "" {
			queryParams = append(queryParams, fmt.Sprintf("access_token=%s", cfg.BearerToken))
		}
		if cfg.APIKey != "" {
			queryParams = append(queryParams, fmt.Sprintf("key=%s", cfg.APIKey))
		}
		if cfg.BearerToken != "" {
			queryParams = append(queryParams, fmt.Sprintf("oauth_token=%s", cfg.BearerToken))
		}
		queryString := ""
		if len(queryParams) > 0 {
			queryString = "?" + strings.Join(queryParams, "&")
		}
		// Create properly typed request body using the generated schema
		var requestBody models.Instance
		
		// Optimized: Single marshal/unmarshal with JSON tags handling field mapping
		if argsJSON, err := json.Marshal(args); err == nil {
			if err := json.Unmarshal(argsJSON, &requestBody); err != nil {
				return mcp.NewToolResultError(fmt.Sprintf("Failed to convert arguments to request type: %v", err)), nil
			}
		} else {
			return mcp.NewToolResultError(fmt.Sprintf("Failed to marshal arguments: %v", err)), nil
		}
		
		bodyBytes, err := json.Marshal(requestBody)
		if err != nil {
			return mcp.NewToolResultErrorFromErr("Failed to encode request body", err), nil
		}
		url := fmt.Sprintf("%s/v1beta2/%s/instances%s", cfg.BaseURL, parent, queryString)
		req, err := http.NewRequest("POST", url, bytes.NewBuffer(bodyBytes))
		req.Header.Set("Content-Type", "application/json")
		if err != nil {
			return mcp.NewToolResultErrorFromErr("Failed to create request", err), nil
		}
		// Set authentication based on auth type
		// Handle multiple authentication parameters
		// API key already added to query string
		// API key already added to query string
		// API key already added to query string
		req.Header.Set("Accept", "application/json")

		resp, err := http.DefaultClient.Do(req)
		if err != nil {
			return mcp.NewToolResultErrorFromErr("Request failed", err), nil
		}
		defer resp.Body.Close()

		body, err := io.ReadAll(resp.Body)
		if err != nil {
			return mcp.NewToolResultErrorFromErr("Failed to read response body", err), nil
		}

		if resp.StatusCode >= 400 {
			return mcp.NewToolResultError(fmt.Sprintf("API error: %s", body)), nil
		}
		// Use properly typed response
		var result models.Operation
		if err := json.Unmarshal(body, &result); err != nil {
			// Fallback to raw text if unmarshaling fails
			return mcp.NewToolResultText(string(body)), nil
		}

		prettyJSON, err := json.MarshalIndent(result, "", "  ")
		if err != nil {
			return mcp.NewToolResultErrorFromErr("Failed to format JSON", err), nil
		}

		return mcp.NewToolResultText(string(prettyJSON)), nil
	}
}

func CreateMemcache_projects_locations_instances_createTool(cfg *config.APIConfig) models.Tool {
	tool := mcp.NewTool("post_v1beta2_parent_instances",
		mcp.WithDescription("Creates a new Instance in a given location."),
		mcp.WithString("$.xgafv", mcp.Description("V1 error format.")),
		mcp.WithString("access_token", mcp.Description("OAuth access token.")),
		mcp.WithString("alt", mcp.Description("Data format for response.")),
		mcp.WithString("callback", mcp.Description("JSONP")),
		mcp.WithString("fields", mcp.Description("Selector specifying which fields to include in a partial response.")),
		mcp.WithString("key", mcp.Description("API key. Your API key identifies your project and provides you with API access, quota, and reports. Required unless you provide an OAuth 2.0 token.")),
		mcp.WithString("oauth_token", mcp.Description("OAuth 2.0 token for the current user.")),
		mcp.WithBoolean("prettyPrint", mcp.Description("Returns response with indentations and line breaks.")),
		mcp.WithString("quotaUser", mcp.Description("Available to use for quota purposes for server-side applications. Can be any arbitrary string assigned to a user, but should not exceed 40 characters.")),
		mcp.WithString("upload_protocol", mcp.Description("Upload protocol for media (e.g. \"raw\", \"multipart\").")),
		mcp.WithString("uploadType", mcp.Description("Legacy upload protocol for media (e.g. \"media\", \"multipart\").")),
		mcp.WithString("parent", mcp.Required(), mcp.Description("Required. The resource name of the instance location using the form: `projects/{project_id}/locations/{location_id}` where `location_id` refers to a GCP region")),
		mcp.WithString("instanceId", mcp.Description("Required. The logical name of the Memcached instance in the user project with the following restrictions: * Must contain only lowercase letters, numbers, and hyphens. * Must start with a letter. * Must be between 1-40 characters. * Must end with a number or a letter. * Must be unique within the user project / location. If any of the above are not met, the API raises an invalid argument error.")),
		mcp.WithString("state", mcp.Description("Input parameter: Output only. The state of this Memcached instance.")),
		mcp.WithString("createTime", mcp.Description("Input parameter: Output only. The time the instance was created.")),
		mcp.WithString("updateTime", mcp.Description("Input parameter: Output only. The time the instance was updated.")),
		mcp.WithString("authorizedNetwork", mcp.Description("Input parameter: The full name of the Google Compute Engine [network](https://cloud.google.com/vpc/docs/vpc) to which the instance is connected. If left unspecified, the `default` network will be used.")),
		mcp.WithArray("reservedIpRangeId", mcp.Description("Input parameter: Optional. Contains the id of allocated IP address ranges associated with the private service access connection for example, \"test-default\" associated with IP range 10.0.0.0/29.")),
		mcp.WithString("memcacheVersion", mcp.Description("Input parameter: The major version of Memcached software. If not provided, latest supported version will be used. Currently the latest supported major version is `MEMCACHE_1_5`. The minor version will be automatically determined by our system based on the latest supported minor version.")),
		mcp.WithString("displayName", mcp.Description("Input parameter: User provided name for the instance, which is only used for display purposes. Cannot be more than 80 characters.")),
		mcp.WithString("discoveryEndpoint", mcp.Description("Input parameter: Output only. Endpoint for the Discovery API.")),
		mcp.WithNumber("nodeCount", mcp.Description("Input parameter: Required. Number of nodes in the Memcached instance.")),
		mcp.WithObject("maintenanceSchedule", mcp.Description("Input parameter: Upcoming maintenance schedule.")),
		mcp.WithObject("labels", mcp.Description("Input parameter: Resource labels to represent user-provided metadata. Refer to cloud documentation on labels for more details. https://cloud.google.com/compute/docs/labeling-resources")),
		mcp.WithObject("maintenancePolicy", mcp.Description("Input parameter: Maintenance policy per instance.")),
		mcp.WithBoolean("updateAvailable", mcp.Description("Input parameter: Output only. Returns true if there is an update waiting to be applied")),
		mcp.WithArray("memcacheNodes", mcp.Description("Input parameter: Output only. List of Memcached nodes. Refer to Node message for more details.")),
		mcp.WithArray("zones", mcp.Description("Input parameter: Zones in which Memcached nodes should be provisioned. Memcached nodes will be equally distributed across these zones. If not provided, the service will by default create nodes in all zones in the region for the instance.")),
		mcp.WithArray("instanceMessages", mcp.Description("Input parameter: List of messages that describe the current state of the Memcached instance.")),
		mcp.WithString("name", mcp.Description("Input parameter: Required. Unique name of the resource in this scope including project and location using the form: `projects/{project_id}/locations/{location_id}/instances/{instance_id}` Note: Memcached instances are managed and addressed at the regional level so `location_id` here refers to a Google Cloud region; however, users may choose which zones Memcached nodes should be provisioned in within an instance. Refer to zones field for more details.")),
		mcp.WithObject("parameters", mcp.Description("")),
		mcp.WithString("memcacheFullVersion", mcp.Description("Input parameter: Output only. The full version of memcached server running on this instance. System automatically determines the full memcached version for an instance based on the input MemcacheVersion. The full version format will be \"memcached-1.5.16\".")),
		mcp.WithObject("nodeConfig", mcp.Description("Input parameter: Configuration for a Memcached Node.")),
	)

	return models.Tool{
		Definition: tool,
		Handler:    Memcache_projects_locations_instances_createHandler(cfg),
	}
}
