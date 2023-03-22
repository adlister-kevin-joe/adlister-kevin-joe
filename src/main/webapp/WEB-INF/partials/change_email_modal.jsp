<div class="modal fade" id="change-email-modal" tabindex="-1">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title">Change Email</h5>
        <button type="button" class="btn-close" data-bs-dismiss="modal"></button>
      </div>
      <div class="modal-body">

          <form method="post" action="/profile/update/email">
            <div class="mb-3">
              <label for="account-page-email" class="form-label">Email</label>
              <div class="input-group has-validation">
                <input name="form-email" type="text" class="form-control ${invalidemail}" value="${email}" id="account-page-email" required>
                <div class="invalid-feedback">
                  Email is invalid.
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