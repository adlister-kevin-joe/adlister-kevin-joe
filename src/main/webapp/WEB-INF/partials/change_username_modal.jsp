<div class="modal fade" id="change-username-modal" tabindex="-1">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title">Change Username</h5>
        <button type="button" class="btn-close" data-bs-dismiss="modal"></button>
      </div>
      <div class="modal-body">

        <form method="post" action="/profile/update/username">
          <div class="mb-3">
            <label for="account-page-username" class="form-label">Username</label>
            <div class="input-group has-validation">
              <input name="form-username" type="text" class="form-control ${userexists}" value="${username}" id="account-page-username" required>
              <div class="invalid-feedback">
                Username already exists.
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
