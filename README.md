# Event Management System

## Description
Create a system for managing events where users can register for events, view event details, and receive notifications. Event organizers (admins) can create and manage events. Superadmins have additional capabilities.

## Features
### a. User
**Functionalities:**

**Register for Events:**
- Users can browse available events and register for the ones they are interested in.
- Once registered, users receive a confirmation email or notification.
- Users can view a list of events they have registered for in their profile.

**View Event Details:**
- Users can view detailed information about each event, including the event description, date, time, location, and organizer information.
- Users can see a list of attendees and interact with other registered users.

**Receive Notifications:**
- Users receive notifications for upcoming events they have registered for.
- Notifications about any changes or updates to the events.
- Reminders before the event starts.

### b. Admin (Event Organizer)
**Functionalities:**

**Create Events:**
- Admins can create new events by providing event details such as title, description, date, time, location, and capacity.
- Admins can upload images or other media related to the event.
- Admins can set registration limits and deadlines.

**Edit Events:**
- Admins can update event details if there are any changes or new information.
- Admins can extend registration deadlines or increase capacity if needed.

**Delete Events:**
- Admins can delete events that are canceled or no longer relevant.
- When an event is deleted, registered users receive notifications about the cancellation.

**Manage Event Registrations:**
- Admins can view the list of users registered for each event.
- Admins can approve or reject registration requests if there are limitations.
- Admins can export registration lists for offline use.

**Send Notifications:**
- Admins can send announcements or updates about the events to all registered users.
- Admins can send reminders or important information as the event date approaches.

### c. Super-Admin
**Functionalities:**

**Manage Organizers:**
- Superadmins can create, edit, and delete admin (event organizer) accounts.
- Superadmins can assign or revoke admin roles to users.

**Platform-wide Settings:**
- Superadmins can manage platform settings, such as the terms of service, privacy policy, and other global configurations.
- Superadmins can monitor platform usage and generate reports on user activities and event statistics.

**View All Events:**
- Superadmins have access to view all events created on the platform.
- Superadmins can intervene in any event management activities if necessary.

**Manage All Registrations:**
- Superadmins can view and manage registrations across all events.
- Superadmins can handle disputes or issues related to event registrations.

## Implementation Details

### Backend (Spring Boot [Java])

**User Entity:**
- Attributes: id, name, email, role (user, admin, superadmin), registeredEvents (list of event IDs).
- CRUD operations for user management.

**Event Entity:**
- Attributes: id, title, description, date, time, location, capacity, registeredUsers (list of user IDs).
- CRUD operations for event management.

**Notification Service:**
- Service to send emails or push notifications to users about event updates and reminders.

**Role-Based Access Control:**
- Implement security configurations to restrict access based on user roles.

### Frontend (React)

**User Dashboard:**
- View available events, register for events, view registered events, and receive notifications.

**Admin Dashboard:**
- Create, edit, and delete events.
- Manage event registrations and send notifications.

**Superadmin Dashboard:**
- Manage admins and platform settings.
- View all events and manage all registrations.

## Example API Endpoints

### User APIs
- `POST /api/register` - Register a new user.
- `GET /api/events` - List all available events.
- `POST /api/events/{eventId}/register` - Register for an event.
- `GET /api/users/{userId}/events` - List all events registered by a user.

### Admin APIs
- `POST /api/events` - Create a new event.
- `PUT /api/events/{eventId}` - Edit an event.
- `DELETE /api/events/{eventId}` - Delete an event.
- `GET /api/events/{eventId}/registrations` - List all registrations for an event.
- `POST /api/events/{eventId}/notify` - Send notifications to event registrants.

### Superadmin APIs
- `POST /api/admins` - Create a new admin.
- `PUT /api/admins/{adminId}` - Edit an admin.
- `DELETE /api/admins/{adminId}` - Delete an admin.
- `GET /api/platform/settings` - Get platform settings.
- `PUT /api/platform/settings` - Update platform settings.
- `GET /api/events/all` - View all events.
- `GET /api/registrations/all` - View all registrations.

By following this structure, you can build a robust Event Management System with well-defined roles and functionalities. This project will provide you with experience in implementing role-based access control, CRUD operations, and integrating various components such as authentication, notifications, and user management.
