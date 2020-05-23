package com.pratham.skills;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.view.View;

import com.google.android.material.snackbar.Snackbar;
import java.util.ArrayList;
import java.util.List;

public class BaseActivity extends AppCompatActivity {
    private boolean flag = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base);
    }

    protected void requestRunTimePermissions(final Activity activity, final String[] permissions, final int customPermissionConstant) {
        if (permissions.length == 1) {
            if (ActivityCompat.shouldShowRequestPermissionRationale(this, permissions[0])) {
                Snackbar.make(findViewById(android.R.id.content), "App needs permission to work", Snackbar.LENGTH_INDEFINITE).setAction("ENABLE",
                        new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                ActivityCompat.requestPermissions(activity, permissions, customPermissionConstant);
                            }
                        }).show();
            } else {
                ActivityCompat.requestPermissions(this, new String[]{permissions[0]}, customPermissionConstant);
            }
        } else if (permissions.length > 1) {
            final List<String> deniedPermissions = new ArrayList<String>();

            for (String permission : permissions) {
                if (ActivityCompat.checkSelfPermission(this, permission) == PackageManager.PERMISSION_DENIED) {
                    deniedPermissions.add(permission);
                }
            }
            if (deniedPermissions.size() == 1) {
                if (ActivityCompat.shouldShowRequestPermissionRationale(this, deniedPermissions.get(0))) {

                    Snackbar.make(findViewById(android.R.id.content), "App needs permission to work", Snackbar.LENGTH_INDEFINITE).setAction("ENABLE",
                            new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    String[] temp = deniedPermissions.toArray(new String[deniedPermissions.size()]);
                                    ActivityCompat.requestPermissions(activity, temp, customPermissionConstant);
                                }
                            }).show();
                } else {
                    String[] temp = deniedPermissions.toArray(new String[deniedPermissions.size()]);
                    ActivityCompat.requestPermissions(activity, temp, customPermissionConstant);
                }
            } else if (deniedPermissions.size() > 1) {
                final String[] temp = deniedPermissions.toArray(new String[deniedPermissions.size()]);
                if (flag) {
                    Snackbar.make(findViewById(android.R.id.content), "This functionality needs multiple app permissions", Snackbar.LENGTH_INDEFINITE).setAction("ENABLE",
                            new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    ActivityCompat.requestPermissions(activity, temp, customPermissionConstant);
                                }
                            }).show();
                } else {
                    flag = true;
                    ActivityCompat.requestPermissions(activity, temp, customPermissionConstant);
                }
            }
        }
    }

    public boolean isPermissionsGranted(Context context, String permissions[]) {
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.M)
            return true;
        boolean granted = true;
        for (String permission : permissions) {
            if (!(ActivityCompat.checkSelfPermission(context, permission) == PackageManager.PERMISSION_GRANTED))
                granted = false;
        }
        return granted;
    }

    protected boolean checkWhetherAllPermissionsPresent(String[] permissionsNeeded) {
        for (String permission : permissionsNeeded) {
            if (ActivityCompat.checkSelfPermission(this, permission) == PackageManager.PERMISSION_DENIED) {
                return false;
            }
        }
        return true;
    }

    protected String[] getDeniedPermissions(String[] permissionsNeeded) {
        String[] deniedPermissionsArray;
        final List<String> deniedPermissions = new ArrayList<String>();
        for (String permission : permissionsNeeded) {
            if (ActivityCompat.checkSelfPermission(this, permission) == PackageManager.PERMISSION_DENIED) {
                deniedPermissions.add(permission);
            }
        }
        deniedPermissionsArray = deniedPermissions.toArray(new String[deniedPermissions.size()]);
        return deniedPermissionsArray;
    }
}
