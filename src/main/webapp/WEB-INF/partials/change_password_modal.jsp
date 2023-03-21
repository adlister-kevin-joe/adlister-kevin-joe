<div class="modal fade" id="change-password-modal" tabindex="-1">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title">Change Password</h5>
        <button type="button" class="btn-close" data-bs-dismiss="modal"></button>
      </div>
      <div class="modal-body">

        <form method="post" action="/profile/update/password">
          <div class="mb-3 ms-5">
            <label for="old-password" class="form-label">Old Password</label>
            <div class="input-group has-validation w-50">
              <input name="old-password" type="password" class="form-control ${incorrectpassword}"
                     id="old-password" required>
              <div class="invalid-feedback">
                Password is invalid.
              </div>
            </div>
          </div>

          <div class="mb-3 ms-5">
            <label for="new-password" class="form-label">New Password</label>
            <div class="input-group has-validation w-50">
              <input name="form-password" type="password" class="form-control ${passwordmismatch}"
                     id="new-password" required>
              <div class="invalid-feedback">
              </div>
            </div>
          </div>

          <div class="mb-3 ms-5">
            <label for="confirm-form-password" class="form-label">Confirm New Password</label>
            <div class="input-group has-validation w-50">
              <input name="confirm-form-password" type="password"
                     class="form-control ${passwordmismatch}" id="confirm-form-password" required>
              <div id="validationServerConfirmPasswordFeedback" class="invalid-feedback">
              </div>
              <div id="validationServerEmailFeedback" class="invalid-feedback">
                Passwords do not match, re-enter.
              </div>
            </div>
          </div>

          <div class="modal-footer">
            <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
            <button type="submit" class="btn btn-primary">Save</button>
          </div>

        </form>

      </div>
    </div>
  </div>
</div>
