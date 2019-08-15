/**
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech) (3.0.0-SNAPSHOT).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */
package com.diviso.graeshoppe.payment.client.bpmn.api;

import com.diviso.graeshoppe.payment.client.bpmn.model.DataResponse;
import com.diviso.graeshoppe.payment.client.bpmn.model.GroupRequest;
import com.diviso.graeshoppe.payment.client.bpmn.model.GroupResponse;
import com.diviso.graeshoppe.payment.client.bpmn.model.MembershipRequest;
import com.diviso.graeshoppe.payment.client.bpmn.model.MembershipResponse;
import io.swagger.annotations.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import javax.validation.constraints.*;
import java.util.List;
import java.util.Map;
import java.util.Optional;
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2019-08-15T10:23:39.926964+05:30[Asia/Kolkata]")

@Api(value = "Groups", description = "the Groups API")
public interface GroupsApi {

    @ApiOperation(value = "Create a group", nickname = "createGroup", notes = "", response = GroupResponse.class, authorizations = {
        @Authorization(value = "basicAuth")
    }, tags={ "Groups", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "successful operation", response = GroupResponse.class),
        @ApiResponse(code = 201, message = "Indicates the group was created."),
        @ApiResponse(code = 400, message = "Indicates the id of the group was missing.") })
    @RequestMapping(value = "/identity/groups",
        produces = "application/json", 
        method = RequestMethod.POST)
    ResponseEntity<GroupResponse> createGroup(@ApiParam(value = ""  )  @Valid @RequestBody GroupRequest groupRequest);


    @ApiOperation(value = "Add a member to a group", nickname = "createMembership", notes = "", response = MembershipResponse.class, authorizations = {
        @Authorization(value = "basicAuth")
    }, tags={ "Groups", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "successful operation", response = MembershipResponse.class),
        @ApiResponse(code = 201, message = "Indicates the group was found and the member has been added."),
        @ApiResponse(code = 400, message = "Indicates the userId was not included in the request body."),
        @ApiResponse(code = 404, message = "Indicates the requested group was not found."),
        @ApiResponse(code = 409, message = "Indicates the requested user is already a member of the group.") })
    @RequestMapping(value = "/identity/groups/{groupId}/members",
        produces = "application/json", 
        method = RequestMethod.POST)
    ResponseEntity<MembershipResponse> createMembership(@ApiParam(value = "The id of the group to add a member to.",required=true) @PathVariable("groupId") String groupId,@ApiParam(value = ""  )  @Valid @RequestBody MembershipRequest membershipRequest);


    @ApiOperation(value = "Delete a group", nickname = "deleteGroup", notes = "", authorizations = {
        @Authorization(value = "basicAuth")
    }, tags={ "Groups", })
    @ApiResponses(value = { 
        @ApiResponse(code = 204, message = "Indicates the group was found and  has been deleted. Response-body is intentionally empty."),
        @ApiResponse(code = 404, message = "Indicates the requested group does not exist.") })
    @RequestMapping(value = "/identity/groups/{groupId}",
        method = RequestMethod.DELETE)
    ResponseEntity<Void> deleteGroup(@ApiParam(value = "The id of the group to delete.",required=true) @PathVariable("groupId") String groupId);


    @ApiOperation(value = "Delete a member from a group", nickname = "deleteMembership", notes = "", authorizations = {
        @Authorization(value = "basicAuth")
    }, tags={ "Groups", })
    @ApiResponses(value = { 
        @ApiResponse(code = 204, message = "Indicates the group was found and the member has been deleted. The response body is left empty intentionally."),
        @ApiResponse(code = 404, message = "Indicates the requested group was not found or that the user is not a member of the group. The status description contains additional information about the error.") })
    @RequestMapping(value = "/identity/groups/{groupId}/members/{userId}",
        method = RequestMethod.DELETE)
    ResponseEntity<Void> deleteMembership(@ApiParam(value = "The id of the group to remove a member from.",required=true) @PathVariable("groupId") String groupId,@ApiParam(value = "The id of the user to remove.",required=true) @PathVariable("userId") String userId);


    @ApiOperation(value = "Get a single group", nickname = "getGroup", notes = "", response = GroupResponse.class, authorizations = {
        @Authorization(value = "basicAuth")
    }, tags={ "Groups", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "Indicates the group exists and is returned.", response = GroupResponse.class),
        @ApiResponse(code = 404, message = "Indicates the requested group does not exist.") })
    @RequestMapping(value = "/identity/groups/{groupId}",
        produces = "application/json", 
        method = RequestMethod.GET)
    ResponseEntity<GroupResponse> getGroup(@ApiParam(value = "The id of the group to get.",required=true) @PathVariable("groupId") String groupId);


    @ApiOperation(value = "Get a list of groups", nickname = "getGroups", notes = "", response = DataResponse.class, authorizations = {
        @Authorization(value = "basicAuth")
    }, tags={ "Groups", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "Indicates the requested groups were returned.", response = DataResponse.class) })
    @RequestMapping(value = "/identity/groups",
        produces = "application/json", 
        method = RequestMethod.GET)
    ResponseEntity<DataResponse> getGroups(@ApiParam(value = "Only return group with the given id") @Valid @RequestParam(value = "id", required = false) String id,@ApiParam(value = "Only return groups with the given name") @Valid @RequestParam(value = "name", required = false) String name,@ApiParam(value = "Only return groups with the given type") @Valid @RequestParam(value = "type", required = false) String type,@ApiParam(value = "Only return groups with a name like the given value. Use % as wildcard-character.") @Valid @RequestParam(value = "nameLike", required = false) String nameLike,@ApiParam(value = "Only return groups which have a member with the given username.") @Valid @RequestParam(value = "member", required = false) String member,@ApiParam(value = "Only return groups which members are potential starters for a process-definition with the given id.") @Valid @RequestParam(value = "potentialStarter", required = false) String potentialStarter,@ApiParam(value = "Property to sort on, to be used together with the order.", allowableValues = "id, name, type") @Valid @RequestParam(value = "sort", required = false) String sort);


    @ApiOperation(value = "Update a group", nickname = "updateGroup", notes = "All request values are optional. For example, you can only include the name attribute in the request body JSON-object, only updating the name of the group, leaving all other fields unaffected. When an attribute is explicitly included and is set to null, the group-value will be updated to null.", response = GroupResponse.class, authorizations = {
        @Authorization(value = "basicAuth")
    }, tags={ "Groups", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "successful operation", response = GroupResponse.class),
        @ApiResponse(code = 201, message = "Indicates the group was updated."),
        @ApiResponse(code = 404, message = "Indicates the requested group was not found."),
        @ApiResponse(code = 409, message = "Indicates the requested group was updated simultaneously.") })
    @RequestMapping(value = "/identity/groups/{groupId}",
        produces = "application/json", 
        method = RequestMethod.PUT)
    ResponseEntity<GroupResponse> updateGroup(@ApiParam(value = "",required=true) @PathVariable("groupId") String groupId,@ApiParam(value = ""  )  @Valid @RequestBody GroupRequest groupRequest);

}
