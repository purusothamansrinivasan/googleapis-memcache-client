package tools

import (
	"context"
	"encoding/json"
	"fmt"
	"io"
	"net/http"
	"strings"

	"github.com/cloud-memorystore-for-memcached-api/mcp-server/config"
	"github.com/cloud-memorystore-for-memcached-api/mcp-server/models"
	"github.com/mark3labs/mcp-go/mcp"
)

func Memcache_projects_locations_listHandler(cfg *config.APIConfig) func(ctx context.Context, request mcp.CallToolRequest) (*mcp.CallToolResult, error) {
	return func(ctx context.Context, request mcp.CallToolRequest) (*mcp.CallToolResult, error) {
		args, ok := request.Params.Arguments.(map[string]any)
		if !ok {
			return mcp.NewToolResultError("Invalid arguments object"), nil
		}
		nameVal, ok := args["name"]
		if !ok {
			return mcp.NewToolResultError("Missing required path parameter: name"), nil
		}
		name, ok := nameVal.(string)
		if !ok {
			return mcp.NewToolResultError("Invalid path parameter: name"), nil
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
		if val, ok := args["filter"]; ok {
			queryParams = append(queryParams, fmt.Sprintf("filter=%v", val))
		}
		if val, ok := args["pageSize"]; ok {
			queryParams = append(queryParams, fmt.Sprintf("pageSize=%v", val))
		}
		if val, ok := args["pageToken"]; ok {
			queryParams = append(queryParams, fmt.Sprintf("pageToken=%v", val))
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
		url := fmt.Sprintf("%s/v1beta2/%s/locations%s", cfg.BaseURL, name, queryString)
		req, err := http.NewRequest("GET", url, nil)
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
		var result models.ListLocationsResponse
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

func CreateMemcache_projects_locations_listTool(cfg *config.APIConfig) models.Tool {
	tool := mcp.NewTool("get_v1beta2_name_locations",
		mcp.WithDescription("Lists information about the supported locations for this service."),
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
		mcp.WithString("name", mcp.Required(), mcp.Description("The resource that owns the locations collection, if applicable.")),
		mcp.WithString("filter", mcp.Description("A filter to narrow down results to a preferred subset. The filtering language accepts strings like `\"displayName=tokyo\"`, and is documented in more detail in [AIP-160](https://google.aip.dev/160).")),
		mcp.WithNumber("pageSize", mcp.Description("The maximum number of results to return. If not set, the service selects a default.")),
		mcp.WithString("pageToken", mcp.Description("A page token received from the `next_page_token` field in the response. Send that page token to receive the subsequent page.")),
	)

	return models.Tool{
		Definition: tool,
		Handler:    Memcache_projects_locations_listHandler(cfg),
	}
}
